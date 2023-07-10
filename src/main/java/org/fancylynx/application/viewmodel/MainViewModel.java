package org.fancylynx.application.viewmodel;

import org.springframework.stereotype.Component;

@Component
public class MainViewModel {
    private TourLogViewModel tourLogViewModel;

    public MainViewModel(TourLogViewModel tourLogViewModel) {
        this.tourLogViewModel = tourLogViewModel;
    }
}
