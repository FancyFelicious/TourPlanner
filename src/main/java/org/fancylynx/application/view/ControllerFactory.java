package org.fancylynx.application.view;

import org.fancylynx.application.BL.service.*;
import org.fancylynx.application.DAL.repository.TourLogRepository;
import org.fancylynx.application.DAL.repository.TourRepository;
import org.fancylynx.application.viewmodel.*;
import org.springframework.context.ConfigurableApplicationContext;

public class ControllerFactory {
    private final MainViewModel mainViewModel;
    private final TourOverviewViewModel tourOverviewViewModel;
    private final TourDetailsViewModel tourDetailsViewModel;
    private final TourLogOverviewViewModel tourLogOverviewViewModel;
    private final TourLogDetailsViewModel tourLogDetailsViewModel;
    private final SearchBarViewModel searchBarViewModel;

    public ControllerFactory(ConfigurableApplicationContext applicationContext) {
        TourLogService tourLogService = new TourLogServiceImpl(applicationContext.getBean(TourLogRepository.class));
        TourServiceNew tourService = new TourServiceImpl(applicationContext.getBean(TourRepository.class));
        RouteService routeService = new RouteServiceImpl();

        this.tourOverviewViewModel = new TourOverviewViewModel(tourService);
        this.tourDetailsViewModel = new TourDetailsViewModel(tourService, routeService);
        this.tourLogOverviewViewModel = new TourLogOverviewViewModel(tourLogService);
        this.tourLogDetailsViewModel = new TourLogDetailsViewModel(tourLogService);
        this.searchBarViewModel = new SearchBarViewModel();
        this.mainViewModel = new MainViewModel(tourOverviewViewModel, tourDetailsViewModel, tourLogOverviewViewModel, tourLogDetailsViewModel, searchBarViewModel);
    }

    public Object create(Class<?> controllerClass) {
        if (controllerClass == MainController.class) {
            return new MainController(mainViewModel);
        } else if (controllerClass == TourOverviewController.class) {
            return new TourOverviewController(tourOverviewViewModel);
        } else if (controllerClass == TourDetailsController.class) {
            return new TourDetailsController(tourDetailsViewModel);
        } else if (controllerClass == TourLogOverviewController.class) {
            return new TourLogOverviewController(tourLogOverviewViewModel);
        } else if (controllerClass == TourLogDetailsController.class) {
            return new TourLogDetailsController(tourLogDetailsViewModel);
        } else if (controllerClass == SearchBarController.class) {
            return new SearchBarController(searchBarViewModel);
        } else {
            throw new IllegalArgumentException("Unknown controller class: " + controllerClass);
        }
    }

    private static ControllerFactory instance;

    public static ControllerFactory getInstance(ConfigurableApplicationContext applicationContext) {
        if (instance == null) {
            instance = new ControllerFactory(applicationContext);
        }
        return instance;
    }
}
