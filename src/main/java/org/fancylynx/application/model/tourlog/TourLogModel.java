package org.fancylynx.application.model.tourlog;

import org.fancylynx.application.entity.TourLog;

import java.util.List;

// 2do
public interface TourLogModel {
    void createNewTourLog(TourLog tourLog);

    List<TourLog> getTourLogsForTour(Long tourId);
}
