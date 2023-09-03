package org.fancylynx.application.viewmodel;

import javafx.beans.property.ObjectProperty;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.springframework.stereotype.Component;

@Component
public class MainViewModel {
    private TourViewModel tourViewModel;
    private TourLogOverviewViewModel tourLogOverviewViewModel;


    public MainViewModel(TourViewModel tourViewModel, TourLogOverviewViewModel tourLogOverviewViewModel) {
        this.tourViewModel = tourViewModel;
        this.tourLogOverviewViewModel = tourLogOverviewViewModel;

        this.tourLogOverviewViewModel.addSelectionChangedListener(this::selectTourLog);
    }

    public void selectTourLog(TourLogModel tourLogModel) {
        tourLogOverviewViewModel.setTourLogModel(tourLogModel);
    }

    public void selectTour(TourModelNew tour){
        tourLogOverviewViewModel.setTour(tour);
    }
}
