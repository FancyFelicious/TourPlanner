package org.fancylynx.application.factory;

import org.fancylynx.application.viewmodel.CreateTourViewModel;
import org.fancylynx.application.viewmodel.HomeViewModel;
import org.springframework.stereotype.Component;

@Component
public class ViewModelFactory {
    private final HomeViewModel homeViewModel;
    private final CreateTourViewModel createTourViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        homeViewModel = new HomeViewModel(modelFactory.getDataModel());
        createTourViewModel = new CreateTourViewModel(modelFactory.getDataModel());
    }

    public HomeViewModel getHomeViewModel() {
        return homeViewModel;
    }

    public CreateTourViewModel getCreateTourViewModel() {
        return createTourViewModel;
    }

}
