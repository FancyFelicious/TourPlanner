package org.fancylynx.application.factory;

import org.fancylynx.application.viewmodel.MainViewModel;
import org.fancylynx.application.viewmodel.TourViewModel;
import org.springframework.stereotype.Component;

@Component
public class ViewModelFactory {
    private final TourViewModel tourViewModel;
    private final MainViewModel mainViewModel;

    public ViewModelFactory(TourViewModel tourViewModel, MainViewModel mainViewModel) {
        this.tourViewModel = tourViewModel;
        this.mainViewModel = mainViewModel;
    }


    public TourViewModel getTourModelView() {
        return tourViewModel;
    }

    public MainViewModel getMainViewModel() {
        return mainViewModel;
    }
}
