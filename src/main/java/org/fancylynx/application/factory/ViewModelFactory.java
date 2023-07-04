package org.fancylynx.application.factory;

import org.fancylynx.application.viewmodel.HomeViewModel;
import org.fancylynx.application.viewmodel.MainViewModel;
import org.fancylynx.application.viewmodel.TourViewModel;
import org.springframework.stereotype.Component;

@Component
public class ViewModelFactory {
    private final HomeViewModel homeViewModel;
    private final TourViewModel tourViewModel;
    private final MainViewModel mainViewModel;

    public ViewModelFactory(HomeViewModel homeViewModel, TourViewModel tourViewModel, MainViewModel mainViewModel) {
        this.homeViewModel = homeViewModel;
        this.tourViewModel = tourViewModel;
        this.mainViewModel = mainViewModel;
    }

    public HomeViewModel getHomeViewModel() {
        return homeViewModel;
    }

    public TourViewModel getTourModelView() {
        return tourViewModel;
    }

    public MainViewModel getMainViewModel() {
        return mainViewModel;
    }
}
