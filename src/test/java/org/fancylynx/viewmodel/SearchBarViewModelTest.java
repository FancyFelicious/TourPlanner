package org.fancylynx.viewmodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.fancylynx.application.viewmodel.SearchBarViewModel;
import org.fancylynx.application.viewmodel.TourDetailsViewModel;
import org.fancylynx.application.viewmodel.TourOverviewViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.fancylynx.TourProvider.provideTourLogs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class SearchBarViewModelTest {

    @Test
    void validSearch() {
        TourOverviewViewModel tourOverviewViewModel = mock(TourOverviewViewModel.class);
        TourDetailsViewModel tourDetailsViewModel = mock(TourDetailsViewModel.class);
        TourServiceNew tourService = mock(TourServiceNew.class);
        TourLogService tourLogService = mock(TourLogService.class);

        SearchBarViewModel searchBarViewModel = new SearchBarViewModel(tourOverviewViewModel, tourDetailsViewModel, tourService, tourLogService);
        Mockito.when(tourService.getAllTours()).thenReturn(provideTours());
        Mockito.when(tourLogService.getAllTourLogs(Mockito.anyLong())).thenReturn(provideTourLogs());
        Mockito.when(tourDetailsViewModel.calculatePopularity(Mockito.any())).thenReturn("Somewhat popular: 2 logs");

        searchBarViewModel.doSearch("amazing tour");
        assertEquals(searchBarViewModel.getFilteredTours().size(), 2);
    }

    @Test
    void computedAttributeSearch() {
        TourOverviewViewModel tourOverviewViewModel = mock(TourOverviewViewModel.class);
        TourDetailsViewModel tourDetailsViewModel = mock(TourDetailsViewModel.class);
        TourServiceNew tourService = mock(TourServiceNew.class);
        TourLogService tourLogService = mock(TourLogService.class);

        SearchBarViewModel searchBarViewModel = new SearchBarViewModel(tourOverviewViewModel, tourDetailsViewModel, tourService, tourLogService);
        Mockito.when(tourService.getAllTours()).thenReturn(provideTours());
        Mockito.when(tourLogService.getAllTourLogs(Mockito.anyLong())).thenReturn(provideTourLogs());
        Mockito.when(tourDetailsViewModel.calculatePopularity(Mockito.any())).thenReturn("Somewhat popular: 2 logs");

        searchBarViewModel.doSearch("somewhat popular");
        assertEquals(searchBarViewModel.getFilteredTours().size(), 4);
    }

    @Test
    void searchTourLogs() {
        TourOverviewViewModel tourOverviewViewModel = mock(TourOverviewViewModel.class);
        TourDetailsViewModel tourDetailsViewModel = mock(TourDetailsViewModel.class);
        TourServiceNew tourService = mock(TourServiceNew.class);
        TourLogService tourLogService = mock(TourLogService.class);

        SearchBarViewModel searchBarViewModel = new SearchBarViewModel(tourOverviewViewModel, tourDetailsViewModel, tourService, tourLogService);
        Mockito.when(tourService.getAllTours()).thenReturn(provideTours());
        Mockito.when(tourLogService.getAllTourLogs(Mockito.anyLong())).thenReturn(provideTourLogsCmt());
        Mockito.when(tourDetailsViewModel.calculatePopularity(Mockito.any())).thenReturn("Somewhat popular: 2 logs");

        searchBarViewModel.doSearch("Pikachu");
        assertEquals(searchBarViewModel.getFilteredTours().size(), 4);
    }
    @Test
    void invalidSearch() {
        ObservableList <TourModelNew> tours = FXCollections.observableArrayList();
        TourOverviewViewModel tourOverviewViewModel = mock(TourOverviewViewModel.class);
        TourDetailsViewModel tourDetailsViewModel = mock(TourDetailsViewModel.class);
        TourServiceNew tourService = mock(TourServiceNew.class);
        TourLogService tourLogService = mock(TourLogService.class);

        SearchBarViewModel searchBarViewModel = new SearchBarViewModel(tourOverviewViewModel, tourDetailsViewModel, tourService, tourLogService);
        Mockito.when(tourService.getAllTours()).thenReturn(provideTours());
        Mockito.when(tourLogService.getAllTourLogs(Mockito.anyLong())).thenReturn(provideTourLogs());
        Mockito.when(tourDetailsViewModel.calculatePopularity(Mockito.any())).thenReturn("Somewhat popular: 2 logs");
        Mockito.when(tourOverviewViewModel.getObservableTours()).thenReturn(tours);

        searchBarViewModel.doSearch("invalid search");
        assertEquals(searchBarViewModel.getFilteredTours().size(), 0);
    }

    private static List<TourModelNew> provideTours() {
        List<TourModelNew> tourModels = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            TourModelNew mockTour = new TourModelNew();

            if (i % 2 == 0) {
                mockTour.setName("Amazing Tour");
            }

            tourModels.add(mockTour);
        }

        return tourModels;
    }


    private static List<TourLogModel> provideTourLogsCmt() {
        List<TourLogModel> tourLogModels = new ArrayList<>();

        TourLogModel mockTourLog = new TourLogModel();
        mockTourLog.setComment("Pikachu");
        tourLogModels.add(mockTourLog);

        return tourLogModels;
    }
}
