package org.fancylynx.application.service;

import org.fancylynx.application.DAL.entity.TourLog;
import org.fancylynx.application.model.tourlog.TourLogModel;

import java.util.List;

public interface TourLogService {
    List<TourLogModel> getAllTourLogs(long tourId);
    Boolean createNewTourLog(TourLog tourLog);
    Boolean deleteTourLog(long tourLogId);
    TourLog updateTourLog(TourLog tourLog);
    TourLog getTourLog(long tourLogId);
}
