package org.fancylynx.application.viewmodel;

import javafx.beans.property.ObjectProperty;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.springframework.stereotype.Component;

@Component
public class MainViewModel {
    private TourViewModel tourViewModel;
    private TourOverviewViewModel tourOverviewViewModel;
    private TourLogOverviewViewModel tourLogOverviewViewModel;
    private TourLogDetailsViewModel tourLogDetailsViewModel;


    public MainViewModel(TourViewModel tourViewModel, TourOverviewViewModel tourOverviewViewModel, TourLogOverviewViewModel tourLogOverviewViewModel, TourLogDetailsViewModel tourLogDetailsViewModel) {
        this.tourViewModel = tourViewModel;
        this.tourOverviewViewModel = tourOverviewViewModel;
        this.tourLogOverviewViewModel = tourLogOverviewViewModel;
        this.tourLogDetailsViewModel = tourLogDetailsViewModel;

        this.tourLogOverviewViewModel.addSelectionChangedListener(this::selectTourLog);
    }

    public void selectTourLog(TourLogModel tourLogModel) {
        tourLogDetailsViewModel.setTourLogModel(tourLogModel);
    }

    public void selectTour(TourModelNew tour){
        tourLogOverviewViewModel.setTour(tour);
    }
}
