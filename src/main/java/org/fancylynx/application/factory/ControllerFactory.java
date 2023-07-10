package org.fancylynx.application.factory;

import org.fancylynx.application.DAL.repository.TourLogRepository;
import org.fancylynx.application.service.TourLogServiceImpl;
import org.fancylynx.application.view.AddTourLogController;
import org.fancylynx.application.view.MainController;
import org.fancylynx.application.view.TourDetailsController;
import org.fancylynx.application.view.TourLogController;
import org.fancylynx.application.viewmodel.AddTourLogViewModel;
import org.fancylynx.application.viewmodel.MainViewModel;
import org.fancylynx.application.viewmodel.TourLogViewModel;
import org.fancylynx.application.viewmodel.TourViewModel;
import org.springframework.context.ConfigurableApplicationContext;

public class ControllerFactory {
    private final MainViewModel mainViewModel;
    private final TourLogViewModel tourLogViewModel;
    //private final TourViewModel tourViewModel;
    private final AddTourLogViewModel addTourLogViewModel;

    public ControllerFactory(ConfigurableApplicationContext applicationContext) {
        TourLogServiceImpl tourLogService = new TourLogServiceImpl(applicationContext.getBean(TourLogRepository.class));
        this.tourLogViewModel = new TourLogViewModel(tourLogService);
        this.mainViewModel = new MainViewModel(tourLogViewModel);
        //this.tourViewModel = new TourViewModel();
        this.addTourLogViewModel = new AddTourLogViewModel();
    }

    public Object create(Class<?> controllerClass) {
        if (controllerClass == MainController.class) {
            return new MainController(mainViewModel);
        } else if (controllerClass == TourLogController.class) {
            return new TourLogController(tourLogViewModel);
        } else if (controllerClass == AddTourLogController.class) {
            return new AddTourLogController();
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
