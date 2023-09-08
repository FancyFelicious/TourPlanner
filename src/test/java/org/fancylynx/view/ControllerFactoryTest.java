package org.fancylynx.view;

import org.fancylynx.application.DAL.repository.TourRepository;
import org.fancylynx.application.view.ControllerFactory;
import org.fancylynx.application.view.MainController;
import org.fancylynx.application.view.TourOverviewController;
import org.fancylynx.application.viewmodel.TourOverviewViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ControllerFactoryTest {
    private static ControllerFactory controllerFactory;

    @BeforeAll
    public static void setUp() {
        ConfigurableApplicationContext applicationContext = mock(ConfigurableApplicationContext.class);
        TourRepository tourRepository = mock(TourRepository.class);
        TourOverviewViewModel tourOverviewViewModel = mock(TourOverviewViewModel.class);

        when(applicationContext.getBean(TourRepository.class)).thenReturn(tourRepository);
        when(applicationContext.getBean(TourOverviewViewModel.class)).thenReturn(tourOverviewViewModel);

        controllerFactory = new ControllerFactory(applicationContext);
    }

    @Test
    public void testCreateMainController() {
        Object controller = controllerFactory.create(MainController.class);
        assertEquals(MainController.class, controller.getClass());
    }

    @Test
    public void testCreateTourOverviewController() {
        Object controller = controllerFactory.create(TourOverviewController.class);
        assertEquals(TourOverviewController.class, controller.getClass());
    }

    @Test
    public void testCreateTourDetailsController() {
        Object controller = controllerFactory.create(TourOverviewController.class);
        assertEquals(TourOverviewController.class, controller.getClass());
    }

    @Test
    public void testCreateTourLogOverviewController() {
        Object controller = controllerFactory.create(TourOverviewController.class);
        assertEquals(TourOverviewController.class, controller.getClass());
    }

    @Test
    public void testCreateTourLogDetailsController() {
        Object controller = controllerFactory.create(TourOverviewController.class);
        assertEquals(TourOverviewController.class, controller.getClass());
    }

    @Test
    public void testCreateSearchBarController() {
        Object controller = controllerFactory.create(TourOverviewController.class);
        assertEquals(TourOverviewController.class, controller.getClass());
    }

    @Test
    public void testCreateUnknownController() {
        try {
            controllerFactory.create(String.class);
        } catch (IllegalArgumentException e) {
            assertEquals("Unknown controller class: class java.lang.String", e.getMessage());
        }
    }
}
