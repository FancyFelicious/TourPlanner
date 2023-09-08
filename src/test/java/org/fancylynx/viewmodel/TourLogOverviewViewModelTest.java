package org.fancylynx.viewmodel;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.viewmodel.TourLogOverviewViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TourLogOverviewViewModelTest {
    @Test
    void displayAllTourLogsForTour() {
        TourLogService tourLogService = mock(TourLogService.class);
        TourLogOverviewViewModel tourLogOverviewViewModel = new TourLogOverviewViewModel(tourLogService);

        Mockito.when(tourLogService.getAllTourLogs(Mockito.anyLong())).thenReturn(provideTourLogs());

        tourLogOverviewViewModel.setTourLogs(tourLogOverviewViewModel.getTourLogs(3));

        assertEquals(tourLogOverviewViewModel.getObservableTourLogs().size(), 9);
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
