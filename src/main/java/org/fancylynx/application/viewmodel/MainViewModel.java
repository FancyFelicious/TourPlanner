package org.fancylynx.application.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.DAL.entity.Tour;
import org.springframework.stereotype.Component;

@Component
public class MainViewModel {
    private TourViewModel tourViewModel;
    private TourLogViewModel tourLogViewModel;


    public MainViewModel(TourViewModel tourViewModel, TourLogViewModel tourLogViewModel) {
        this.tourViewModel = tourViewModel;
        this.tourLogViewModel = tourLogViewModel;

    }

    public void selectTour(ObjectProperty tour){
        tourLogViewModel.setTour(tour);
    }
}
