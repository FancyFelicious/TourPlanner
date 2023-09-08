package org.fancylynx.viewmodel;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.service.RouteService;
import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.fancylynx.application.viewmodel.TourDetailsViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.fancylynx.TourProvider.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TourDetailsViewModelTest {
    @Test
    void popularityTest() {
        TourServiceNew tourServiceNew = mock(TourServiceNew.class);
        RouteService routeService = mock(RouteService.class);
        TourLogService tourLogService = mock(TourLogService.class);

        TourDetailsViewModel tourDetailsViewModel = new TourDetailsViewModel(tourServiceNew, routeService, tourLogService);

        Mockito.when(tourLogService.getAllTourLogs(Mockito.anyLong())).thenReturn(provideTourLogs());

        TourModelNew tourModelNew = provideTour();

        assertEquals(tourDetailsViewModel.calculatePopularity(tourModelNew), "Somewhat popular: 9 logs");


    }

}
