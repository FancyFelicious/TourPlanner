package org.fancylynx.viewmodel;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.RouteService;
import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.fancylynx.application.viewmodel.TourDetailsViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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

    private static TourModelNew provideTour() {
        TourModelNew tourModelNew = new TourModelNew();
        tourModelNew.setTourId(1L);
        tourModelNew.setName("TestTour");
        tourModelNew.setDescription("TestDescription");
        tourModelNew.setFrom("TestFrom");
        tourModelNew.setTo("TestTo");
        tourModelNew.setTransportType("AUTO");
        tourModelNew.setDistance(100.0);
        tourModelNew.setEstimatedTime(100L);
        tourModelNew.setImagePath(null);

        return tourModelNew;
    }

    private static List<TourLogModel> provideTourLogs() {
        List<TourLogModel> tourLogModels = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            TourLogModel mockTourLog = Mockito.mock(TourLogModel.class);
            tourLogModels.add(mockTourLog);
        }

        return tourLogModels;
    }
}
