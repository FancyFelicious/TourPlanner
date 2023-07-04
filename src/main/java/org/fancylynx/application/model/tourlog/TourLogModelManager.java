package org.fancylynx.application.model.tourlog;

import org.fancylynx.application.entity.TourLog;
import org.fancylynx.application.repository.TourLogRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<TourLog> getTourLogsForTour(Long tourId) {
        try {
            return tourLogRepository.findByTourId(tourId);
        } catch (Exception e) {
            System.out.println("Error retrieving tour logs from database: " + e.getMessage());
        }
        return null;
    }
}
