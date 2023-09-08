package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.TourModelNew;

import java.util.List;

public interface TourServiceNew {
    List<TourModelNew> getAllTours();
    TourModelNew createNewTour();
    void updateTour(TourModelNew tourModel);
    TourModelNew importTour(TourModelNew tourModel);
    void deleteTour(TourModelNew tourModelNew);


}
