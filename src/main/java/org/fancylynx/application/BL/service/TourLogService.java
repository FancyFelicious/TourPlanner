package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;

import java.util.List;

public interface TourLogService {
    List<TourLogModel> getAllTourLogs(long tourId);

    TourLogModel createNewTourLog(TourModel tour);

    void deleteTourLog(TourLogModel tourLog);

    void updateTourLog(TourLogModel tourLog);

    void importTourLog(TourLogModel tourLogModel, TourModel tourModel);
}
