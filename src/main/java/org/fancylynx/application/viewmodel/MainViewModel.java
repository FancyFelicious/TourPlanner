package org.fancylynx.application.viewmodel;

import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.ReportService;
import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.fancylynx.application.utility.JsonConverter;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class MainViewModel {
    private static final Logger logger = LogManager.getLogger(MainViewModel.class);
    private final TourOverviewViewModel tourOverviewViewModel;
    private final TourDetailsViewModel tourDetailsViewModel;
    private final TourLogOverviewViewModel tourLogOverviewViewModel;
    private final TourLogDetailsViewModel tourLogDetailsViewModel;
    private final SearchBarViewModel searchBarViewModel;
    private final ReportService reportService;
    private final TourServiceNew tourService;
    private final TourLogService tourLogService;
    private TourModel selectedTour;


    public MainViewModel(TourOverviewViewModel tourOverviewViewModel, TourDetailsViewModel tourDetailsViewModel, TourLogOverviewViewModel tourLogOverviewViewModel, TourLogDetailsViewModel tourLogDetailsViewModel, SearchBarViewModel searchBarViewModel, TourServiceNew tourService, TourLogService tourLogService, ReportService reportService) {
        this.tourOverviewViewModel = tourOverviewViewModel;
        this.tourDetailsViewModel = tourDetailsViewModel;
        this.tourLogOverviewViewModel = tourLogOverviewViewModel;
        this.tourLogDetailsViewModel = tourLogDetailsViewModel;
        this.searchBarViewModel = searchBarViewModel;
        this.tourService = tourService;
        this.tourLogService = tourLogService;
        this.reportService = reportService;

        this.tourOverviewViewModel.addSelectionChangedListener(this::selectTour);
        this.tourLogOverviewViewModel.addSelectionChangedListener(this::selectTourLog);
    }

    public void selectTourLog(TourLogModel tourLogModel) {
        tourLogDetailsViewModel.setTourLogModel(tourLogModel);
    }

    public void selectTour(TourModel tour) {
        this.selectedTour = tour;
        tourLogOverviewViewModel.setTour(tour);
        tourDetailsViewModel.setTour(tour);
    }

    public void importTour(File file) {
        try {
            TourModel tour = JsonConverter.readFromJsonFile(file);
            TourModel importedTour = tourService.importTour(tour);

            for (TourLogModel tourLog : tour.getTourLogs()) {
                tourLogService.importTourLog(tourLog, importedTour);
            }

            tourOverviewViewModel.addTourToList(importedTour);
        } catch (Exception e) {
            logger.error("Error while importing tour from file=[{}]", file, e);
        }

        logger.info("Import tour from file=[{}]", file);
    }

    public void exportTour(File directory) {
        List<TourLogModel> tourLogs = tourLogService.getAllTourLogs(selectedTour.getTourId());
        selectedTour.setTourLogs(tourLogs);

        try {
            String json = JsonConverter.convertToJson(selectedTour);
            try (FileWriter fileWriter = new FileWriter(directory.getAbsolutePath() + "\\" + selectedTour.getName() + ".json")) {
                fileWriter.write(json);
            } catch (IOException e) {
                logger.error("Error while writing tour to file=[{}]", directory.getAbsolutePath() + "\\" + selectedTour.getName() + ".json", e);
            }
        } catch (Exception e) {
            logger.error("Error while exporting tour=[{}] to directory=[{}]", selectedTour.getName(), directory, e);
        }

        logger.info("Export tour to directory=[{}]", directory);
    }

    public void tourReport() {
        reportService.generateTourReport(selectedTour);

        logger.info("Generate tour report for tour=[{}]", selectedTour.getName());
    }

    public void summaryReport() {
        Map<TourModel, List<TourLogModel>> completeTours = new HashMap<>();
        List<TourModel> tours = tourService.getAllTours();

        for (TourModel tour : tours) {
            List<TourLogModel> tourLogs = tourLogService.getAllTourLogs(tour.getTourId());
            completeTours.put(tour, tourLogs);
        }

        reportService.generateSummaryReport(completeTours);

        logger.info("Generate summary report");
    }
}
