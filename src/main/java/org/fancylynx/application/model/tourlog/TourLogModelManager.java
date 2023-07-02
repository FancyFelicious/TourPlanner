package org.fancylynx.application.model.tourlog;

import org.fancylynx.application.entity.TourLog;
import org.fancylynx.application.repository.TourLogRepository;
import org.springframework.stereotype.Repository;

// 2do
@Repository
public class TourLogModelManager implements TourLogModel {
    private final TourLogRepository tourLogRepository;

    public TourLogModelManager(TourLogRepository tourLogRepository) {
        this.tourLogRepository = tourLogRepository;
    }

    @Override
    public void createNewTourLog(TourLog tourLog) {
        tourLogRepository.save(tourLog);
    }
}
