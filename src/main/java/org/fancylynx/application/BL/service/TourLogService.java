package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;

import java.util.List;

public interface TourLogService {
    List<TourLogModel> getAllTourLogs(long tourId);
    TourLogModel createNewTourLog(TourModelNew tour);
    void deleteTourLog(TourLogModel tourLog);
    void updateTourLog(TourLogModel tourLog);
    void importTourLog(TourLogModel tourLogModel, TourModelNew tourModel);
}
