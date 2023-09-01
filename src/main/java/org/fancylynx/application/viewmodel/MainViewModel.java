package org.fancylynx.application.viewmodel;

import javafx.beans.property.ObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class MainViewModel {
    private TourViewModel tourViewModel;
    private TourLogOverviewViewModel tourLogOverviewViewModel;


    public MainViewModel(TourViewModel tourViewModel, TourLogOverviewViewModel tourLogOverviewViewModel) {
        this.tourViewModel = tourViewModel;
        this.tourLogOverviewViewModel = tourLogOverviewViewModel;

    }

    public void selectTour(ObjectProperty tour){
        tourLogOverviewViewModel.setTour(tour);
    }
}
