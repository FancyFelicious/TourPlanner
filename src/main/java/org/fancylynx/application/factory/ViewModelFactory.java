package org.fancylynx.application.factory;

import org.fancylynx.application.viewmodel.HomeViewModel;
import org.fancylynx.application.viewmodel.TourViewModel;
import org.springframework.stereotype.Component;

@Component
public class ViewModelFactory {
    private final HomeViewModel homeViewModel;
    private final TourViewModel tourViewModel;

    public ViewModelFactory(HomeViewModel homeViewModel, TourViewModel tourViewModel) {
        this.homeViewModel = homeViewModel;
        this.tourViewModel = tourViewModel;
    }

    public HomeViewModel getHomeViewModel() {
        return homeViewModel;
    }

    public TourViewModel getTourModelView() {
        return tourViewModel;
    }
}
