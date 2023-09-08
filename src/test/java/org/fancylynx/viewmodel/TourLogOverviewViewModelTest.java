package org.fancylynx.viewmodel;

import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.viewmodel.TourLogOverviewViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.fancylynx.TourProvider.provideTourLogs;
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
}
