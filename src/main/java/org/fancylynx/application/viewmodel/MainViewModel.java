package org.fancylynx.application.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.fancylynx.application.DAL.entity.Tour;
import org.springframework.stereotype.Component;

@Component
public class MainViewModel {
    private TourLogViewModel tourLogViewModel;


    public MainViewModel(TourLogViewModel tourLogViewModel) {
        this.tourLogViewModel = tourLogViewModel;

    }

    public void selectTour(ObjectProperty tour){
        tourLogViewModel.setTour(tour);
    }
}
