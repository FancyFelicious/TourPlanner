package org.fancylynx.application.BL.service;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Component
public class ReportServiceImpl implements ReportService{
    private static final Logger logger = LogManager.getLogger(ReportServiceImpl.class);
    private static final String REPORT_PATH = System.getProperty("user.dir") + "/reports/";
    private static final String MAP_NOT_FOUND = System.getProperty("user.dir") + "/src/main/resources/misc/noMapFound.jpg";
    TourModelNew tour;

    @Override
    public void generateTourReport(TourModelNew tourModel) {
        this.tour = tourModel;
        try {
            PdfWriter writer = new PdfWriter(REPORT_PATH + tourModel.getName() + "_" + System.currentTimeMillis() + ".pdf");
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            document.add(tourHeader());
            document.add(tourTable());
            document.add(tourLogsTable());

            document.close();
        } catch (IOException e) {
            logger.error("Error while generating tour report", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void generateSummaryReport(Map<TourModelNew, List<TourLogModel>> tours) {
        try {
            PdfWriter writer = new PdfWriter(REPORT_PATH + "SummaryReport_" + System.currentTimeMillis() + ".pdf");
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            document.add(summaryHeader());
            Table summaryTable = summaryTableHeader();

            for (Map.Entry<TourModelNew, List<TourLogModel>> entry : tours.entrySet()) {
                summaryTable(summaryTable, entry.getKey(), entry.getValue());
            }

            document.add(summaryTable);

            document.close();
        } catch (IOException e) {
            logger.error("Error while generating summary report", e);
            throw new RuntimeException(e);
        }

    }

    private Paragraph tourHeader() throws IOException {
        String tourName = tour.getName() == null ? "Unknown Tour" : tour.getName();

        return new Paragraph("Tour Report: " + tourName + " - " + new Date() + "\n")
                .setFont(PdfFontFactory.createFont("Helvetica"))
                .setFontSize(20)
                .setBold()
                .setFontColor(ColorConstants.BLACK);
    }

    private Paragraph summaryHeader() throws IOException {
        return new Paragraph("Summary Report - " + new Date() + "\n")
                .setFont(PdfFontFactory.createFont("Helvetica"))
                .setFontSize(20)
                .setBold()
                .setFontColor(ColorConstants.BLACK);
    }

    private Table tourTable() throws MalformedURLException {
        Table table = new Table(UnitValue.createPercentArray(7)).useAllAvailableWidth();
        table.addHeaderCell(getHeaderCell("Map"));
        table.addHeaderCell(getHeaderCell("From"));
        table.addHeaderCell(getHeaderCell("To"));
        table.addHeaderCell(getHeaderCell("Description"));
        table.addHeaderCell(getHeaderCell("Distance"));
        table.addHeaderCell(getHeaderCell("Transportation"));
        table.addHeaderCell(getHeaderCell("Time"));

        table.setFontSize(14).setBackgroundColor(ColorConstants.WHITE);


        if (tour.getImagePath() == null) {
            tour.setImagePath(MAP_NOT_FOUND);
        }

        ImageData imageData = ImageDataFactory.create(tour.getImagePath());

        table.addCell(new Image(imageData).setHeight(100).setWidth(100));
        table.addCell(tour.getFrom() == null ? "" : tour.getFrom());
        table.addCell(tour.getTo() == null ? "" : tour.getTo());
        table.addCell(tour.getDescription() == null ? "" : tour.getDescription());
        table.addCell(String.valueOf(tour.getDistance()));
        table.addCell(tour.getTransportType());
        table.addCell(String.valueOf(tour.getEstimatedTime()));

        return table;
    }

    private Table tourLogsTable() {
        Table table = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();
        table.addHeaderCell(getHeaderCell("Date"));
        table.addHeaderCell(getHeaderCell("Comment"));
        table.addHeaderCell(getHeaderCell("Difficulty"));
        table.addHeaderCell(getHeaderCell("Total Time"));
        table.addHeaderCell(getHeaderCell("Rating"));

        table.setFontSize(14).setBackgroundColor(ColorConstants.WHITE);

        for (int i = 0; i < tour.getTourLogs().size(); i++) {
            table.addCell(tour.getTourLogs().get(i).getDate() == null ? "" : tour.getTourLogs().get(i).getDate().toString());
            table.addCell(tour.getTourLogs().get(i).getComment() == null ? "" : tour.getTourLogs().get(i).getComment());
            table.addCell(String.valueOf(tour.getTourLogs().get(i).getDifficulty()));
            table.addCell(String.valueOf(tour.getTourLogs().get(i).getTotalTime()));
            table.addCell(String.valueOf(tour.getTourLogs().get(i).getRating()));
        }

        return table;
    }

    private Table summaryTableHeader() {
        Table table = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();
        table.addHeaderCell(getHeaderCell("Name"));
        table.addHeaderCell(getHeaderCell("From"));
        table.addHeaderCell(getHeaderCell("To"));
        table.addHeaderCell(getHeaderCell("Distance"));
        table.addHeaderCell(getHeaderCell("Transportation"));
        table.addHeaderCell(getHeaderCell("Difficulty"));
        table.addHeaderCell(getHeaderCell("Rating"));
        table.addHeaderCell(getHeaderCell("Time"));

        return table;
    }

    private void summaryTable(Table table, TourModelNew tour, List<TourLogModel> tourLogs) {
        table.setBackgroundColor(ColorConstants.WHITE);

        table.addCell(tour.getName() == null ? "" : tour.getName());
        table.addCell(tour.getFrom() == null ? "" : tour.getFrom());
        table.addCell(tour.getTo() == null ? "" : tour.getTo());
        table.addCell(String.valueOf(tour.getDistance()));
        table.addCell(tour.getTransportType());
        // only to 2 decimal places


        table.addCell(String.format("%.2f", tourLogs.stream().mapToDouble(TourLogModel::getDifficulty).average().orElse(0)));
        table.addCell(String.format("%.2f", tourLogs.stream().mapToDouble(TourLogModel::getRating).average().orElse(0)));
        table.addCell(String.format("%.2f", tourLogs.stream().mapToDouble(TourLogModel::getTotalTime).average().orElse(0)));

    }

    private static Cell getHeaderCell(String s) {
        return new Cell().add(new Paragraph(s)).setBold().setBackgroundColor(ColorConstants.GRAY);
    }
}
