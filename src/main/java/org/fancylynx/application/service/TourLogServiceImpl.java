package org.fancylynx.application.service;

import org.fancylynx.application.DAL.entity.TourLog;
import org.fancylynx.application.DAL.repository.TourLogRepository;

import java.util.List;

public class TourLogServiceImpl implements TourLogService{
    private final TourLogRepository tourLogRepository;

    public TourLogServiceImpl(TourLogRepository tourLogRepository) {
        this.tourLogRepository = tourLogRepository;
    }

    @Override
    public List<TourLog> getAllTourLogs(long tourId) {
        try {
            return tourLogRepository.findByTourId(tourId);
        } catch (Exception e) {
            System.out.println("Error retrieving tour logs from database: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean createNewTourLog(TourLog tourLog) {
        try {
            tourLogRepository.save(tourLog);
            return true;
        } catch (Exception e) {
            System.out.println("Error saving tour log to database: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean deleteTourLog(long tourLogId) {
        try {
            tourLogRepository.deleteById(tourLogId);
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting tour log from database: " + e.getMessage());
        }
        return false;
    }

    @Override
    public TourLog updateTourLog(TourLog tourLog) {
        try {
            return tourLogRepository.save(tourLog);
        } catch (Exception e) {
            System.out.println("Error updating tour log in database: " + e.getMessage());
        }
        return null;
    }

    @Override
    public TourLog getTourLog(long tourLogId) {
        try {
            return tourLogRepository.findById(tourLogId).orElse(null);
        } catch (Exception e) {
            System.out.println("Error retrieving tour log from database: " + e.getMessage());
        }
        return null;
    }
}
