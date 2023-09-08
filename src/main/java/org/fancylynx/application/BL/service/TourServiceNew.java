package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.TourModel;

import java.util.List;

public interface TourServiceNew {
    List<TourModel> getAllTours();

    TourModel createNewTour();

    void updateTour(TourModel tourModel);

    TourModel importTour(TourModel tourModel);

    void deleteTour(TourModel tourModel);


}
