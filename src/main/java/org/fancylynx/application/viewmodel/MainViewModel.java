package org.fancylynx.application.viewmodel;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.ReportService;
import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.fancylynx.application.utility.JsonConverter;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
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
    private TourModelNew selectedTour;


    public MainViewModel(TourOverviewViewModel tourOverviewViewModel, TourDetailsViewModel tourDetailsViewModel, TourLogOverviewViewModel tourLogOverviewViewModel, TourLogDetailsViewModel tourLogDetailsViewModel, SearchBarViewModel searchBarViewModel, TourServiceNew tourService, TourLogService tourLogService, ReportService reportService) {
        this.tourOverviewViewModel = tourOverviewViewModel;
        this.tourDetailsViewModel = tourDetailsViewModel;
        this.tourLogOverviewViewModel = tourLogOverviewViewModel;
        this.tourLogDetailsViewModel = tourLogDetailsViewModel;
        this.searchBarViewModel = searchBarViewModel;
        this.tourService = tourService;
        this.tourLogService = tourLogService;
        this.reportService = reportService;

        this.searchBarViewModel.addSearchListener(this::searchTours);

        this.tourOverviewViewModel.addSelectionChangedListener(this::selectTour);
        this.tourLogOverviewViewModel.addSelectionChangedListener(this::selectTourLog);
    }

    public void searchTours(String searchString) {
        logger.info("Perform search with searchString=[{}]", searchString);
    }

    public void selectTourLog(TourLogModel tourLogModel) {
        tourLogDetailsViewModel.setTourLogModel(tourLogModel);
    }

    public void selectTour(TourModelNew tour){
        this.selectedTour = tour;
        tourLogOverviewViewModel.setTour(tour);
        tourDetailsViewModel.setTour(tour);
    }

    public void importTour(File file) {
        try {
            TourModelNew tour = JsonConverter.readFromJsonFile(file);
            TourModelNew importedTour = tourService.importTour(tour);

            for (TourLogModel tourLog : tour.getTourLogs()) {
                tourLogService.importTourLog(tourLog, importedTour);
            }

            tourOverviewViewModel.addTourToList(importedTour);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        logger.info("Import tour from file=[{}]", file);
    }

    public void exportTour(File directory) {
        List<TourLogModel> tourLogs = tourLogService.getAllTourLogs(selectedTour.getTourId());
        selectedTour.setTourLogs(tourLogs);

        try {
            JsonConverter.writeToJsonFile(selectedTour, directory.getAbsolutePath() + "\\" + selectedTour.getName() + ".json");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        logger.info("Export tour to directory=[{}]", directory);
    }

    public void tourReport() {
        reportService.generateTourReport(selectedTour);
    }

    public void summaryReport() {
        Map<TourModelNew, List<TourLogModel>> completeTours = new HashMap<>();
        List<TourModelNew> tours = tourService.getAllTours();

        for (TourModelNew tour : tours) {
            List<TourLogModel> tourLogs = tourLogService.getAllTourLogs(tour.getTourId());
            completeTours.put(tour, tourLogs);
        }

        reportService.generateSummaryReport(completeTours);

    }
}
