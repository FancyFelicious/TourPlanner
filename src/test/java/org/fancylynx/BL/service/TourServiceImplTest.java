package org.fancylynx.BL.service;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.service.TourServiceImpl;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.DAL.repository.TourRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TourServiceImplTest {
    private static TourServiceImpl tourService;

    @BeforeAll
    static void setup() {
        TourRepository tourRepository = mock(TourRepository.class);
        tourService = new TourServiceImpl(tourRepository);
    }
    @Test
    void tourToTourModel() {
        var tour = new Tour(1, "Test", "This is a description", "Vienna", "France", "AUTO", 123.1, 123, "images/mhm.png");
        TourModelNew tourModel;
        tourModel = tourService.setValues(tour);

        assertEquals(tourModel.getTourId(), tour.getId());
        assertEquals(tourModel.getName(), tour.getName());
        assertEquals(tourModel.getDescription(), tour.getDescription());
        assertEquals(tourModel.getFrom(), tour.getOrigin());
        assertEquals(tourModel.getTo(), tour.getDestination());
        assertEquals(tourModel.getTransportType(), tour.getTransportType());
        assertEquals(tourModel.getDistance(), tour.getDistance());
    }
}
