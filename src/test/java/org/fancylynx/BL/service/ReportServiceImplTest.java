package org.fancylynx.BL.service;

import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.ReportServiceImpl;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.fancylynx.TourProvider.provideTour;
import static org.fancylynx.TourProvider.provideTourLogs;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReportServiceImplTest {

    private static final String REPORT_PATH = System.getProperty("user.dir") + "/reports/";

    @Test
    void generateReport() {
        ReportServiceImpl reportService = new ReportServiceImpl();

        TourModel tour = provideTour();
        tour.setTourLogs(provideTourLogs());

        reportService.generateTourReport(tour);

        File file = new File(REPORT_PATH + tour.getName() + ".pdf");

        assertTrue(file.exists());

        file.delete();
    }

    @Test
    void generateSummaryReport() {
        ReportServiceImpl reportService = new ReportServiceImpl();

        TourModel tour = provideTour();
        tour.setTourLogs(provideTourLogs());

        Map<TourModel, List<TourLogModel>> tours = Map.of(tour, provideTourLogs());

        reportService.generateSummaryReport(tours);

        File file = new File(REPORT_PATH + "SummaryReport.pdf");

        assertTrue(file.exists());

        file.delete();
    }

}
