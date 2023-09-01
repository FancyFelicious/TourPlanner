package org.fancylynx.application.BL.service;

import org.fancylynx.application.DAL.entity.TourLog;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;

import java.util.List;

public interface TourLogService {
    List<TourLogModel> getAllTourLogs(long tourId);
    TourLogModel createNewTourLog(TourLog tourLog);
    Boolean deleteTourLog(TourLogModel tourLog);
    TourLog updateTourLog(TourLog tourLog);
    TourLog getTourLog(long tourLogId);
}
