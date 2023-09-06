package org.fancylynx.application.viewmodel;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.utility.JsonConverter;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;


@Component
public class MainViewModel {
    private static final Logger logger = LogManager.getLogger(MainViewModel.class);
    private final TourOverviewViewModel tourOverviewViewModel;
    private final TourDetailsViewModel tourDetailsViewModel;
    private final TourLogOverviewViewModel tourLogOverviewViewModel;
    private final TourLogDetailsViewModel tourLogDetailsViewModel;
    private final SearchBarViewModel searchBarViewModel;
    private TourModelNew selectedTour;


    public MainViewModel(TourOverviewViewModel tourOverviewViewModel, TourDetailsViewModel tourDetailsViewModel, TourLogOverviewViewModel tourLogOverviewViewModel, TourLogDetailsViewModel tourLogDetailsViewModel, SearchBarViewModel searchBarViewModel) {
        this.tourOverviewViewModel = tourOverviewViewModel;
        this.tourDetailsViewModel = tourDetailsViewModel;
        this.tourLogOverviewViewModel = tourLogOverviewViewModel;
        this.tourLogDetailsViewModel = tourLogDetailsViewModel;
        this.searchBarViewModel = searchBarViewModel;

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
            TourModelNew importedTour = tourOverviewViewModel.importTour(tour);

            for (TourLogModel tourLog : tour.getTourLogs()) {
                tourLogOverviewViewModel.importTourLog(tourLog, importedTour);
            }

            tourOverviewViewModel.addTourToList(importedTour);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        logger.info("Import tour from file=[{}]", file);
    }

    public void exportTour(File directory) {
        List<TourLogModel> tourLogs = tourLogOverviewViewModel.getTourLogs(selectedTour.getTourId());
        selectedTour.setTourLogs(tourLogs);

        try {
            JsonConverter.writeToJsonFile(selectedTour, directory.getAbsolutePath() + "\\" + selectedTour.getName() + ".json");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        logger.info("Export tour to directory=[{}]", directory);
    }

}
