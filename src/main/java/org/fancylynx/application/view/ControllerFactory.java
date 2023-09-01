package org.fancylynx.application.view;

import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.BL.service.TourServiceImpl;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.fancylynx.application.DAL.repository.TourLogRepository;
import org.fancylynx.application.BL.service.TourLogServiceImpl;
import org.fancylynx.application.viewmodel.MainViewModel;
import org.fancylynx.application.viewmodel.TourLogDetailsViewModel;
import org.fancylynx.application.viewmodel.TourLogOverviewViewModel;
import org.fancylynx.application.viewmodel.TourViewModel;
import org.springframework.context.ConfigurableApplicationContext;

public class ControllerFactory {
    private final MainViewModel mainViewModel;
    private final TourLogOverviewViewModel tourLogOverviewViewModel;
    private final TourLogDetailsViewModel tourLogDetailsViewModel;
    private final TourViewModel tourViewModel;

    public ControllerFactory(ConfigurableApplicationContext applicationContext) {
        TourLogService tourLogService = new TourLogServiceImpl(applicationContext.getBean(TourLogRepository.class));
        TourServiceNew tourService = new TourServiceImpl();

        this.tourLogOverviewViewModel = new TourLogOverviewViewModel(tourLogService);
        this.tourLogDetailsViewModel = new TourLogDetailsViewModel();
        this.tourViewModel = new TourViewModel(tourService);
        this.mainViewModel = new MainViewModel(tourViewModel, tourLogOverviewViewModel);
    }

    public Object create(Class<?> controllerClass) {
        if (controllerClass == MainController.class) {
            return new MainController(mainViewModel);
        } else if (controllerClass == TourLogOverviewController.class) {
            return new TourLogOverviewController(tourLogOverviewViewModel);
        } else if (controllerClass == TourController.class) {
            return new TourController(tourViewModel);
        } else if (controllerClass == TourLogDetailsController.class) {
            return new TourLogDetailsController(tourLogDetailsViewModel);
        }
        else {
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
