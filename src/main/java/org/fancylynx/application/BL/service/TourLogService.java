package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.DAL.entity.TourLog;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;

import java.util.List;

public interface TourLogService {
    List<TourLogModel> getAllTourLogs(long tourId);
    TourLogModel createNewTourLog(TourModelNew tour);
    Boolean deleteTourLog(TourLogModel tourLog);
    void updateTourLog(TourLogModel tourLog);
    TourLog getTourLog(long tourLogId);
}
