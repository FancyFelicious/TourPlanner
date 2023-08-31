package org.fancylynx.application.view;

import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.BL.service.TourServiceImpl;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.fancylynx.application.DAL.repository.TourLogRepository;
import org.fancylynx.application.BL.service.TourLogServiceImpl;
import org.fancylynx.application.viewmodel.MainViewModel;
import org.fancylynx.application.viewmodel.TourLogViewModel;
import org.fancylynx.application.viewmodel.TourViewModel;
import org.springframework.context.ConfigurableApplicationContext;

public class ControllerFactory {
    private final MainViewModel mainViewModel;
    private final TourLogViewModel tourLogViewModel;
    private final TourViewModel tourViewModel;

    public ControllerFactory(ConfigurableApplicationContext applicationContext) {
        TourLogService tourLogService = new TourLogServiceImpl(applicationContext.getBean(TourLogRepository.class));
        TourServiceNew tourService = new TourServiceImpl();

        this.tourLogViewModel = new TourLogViewModel(tourLogService);
        this.tourViewModel = new TourViewModel(tourService);
        this.mainViewModel = new MainViewModel(tourViewModel, tourLogViewModel);
    }

    public Object create(Class<?> controllerClass) {
        if (controllerClass == MainController.class) {
            return new MainController(mainViewModel);
        } else if (controllerClass == TourLogController.class) {
            return new TourLogController(tourLogViewModel);
        } else if (controllerClass == TourController.class) {
            return new TourController(tourViewModel);
        }
        else if (controllerClass == AddTourLogController.class) {
            AddTourLogController addTourLogController = new AddTourLogController();
            addTourLogController.setTourLogViewModel(tourLogViewModel);
            return addTourLogController;
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
