package org.fancylynx.BL.service;

import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.BL.service.TourLogServiceImpl;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.DAL.repository.TourLogRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.fancylynx.TourProvider.provideTour;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TourLogServiceImplTest {
    private static TourLogServiceImpl tourLogService;

    @BeforeAll
    static void setup() {
        TourLogRepository tourLogRepository = mock(TourLogRepository.class);
        tourLogService = new TourLogServiceImpl(tourLogRepository);
    }

    @Test
    void tourModelToTour() {
        Tour tour;
        TourModel tourModel = provideTour();

        tour = tourLogService.setTourValues(tourModel);

        assertEquals(tourModel.getTourId(), tour.getId());
        assertEquals(tourModel.getName(), tour.getName());
        assertEquals(tourModel.getDescription(), tour.getDescription());
        assertEquals(tourModel.getFrom(), tour.getOrigin());
        assertEquals(tourModel.getTo(), tour.getDestination());
        assertEquals(tourModel.getTransportType(), tour.getTransportType());
        assertEquals(tourModel.getDistance(), tour.getDistance());
    }

}
