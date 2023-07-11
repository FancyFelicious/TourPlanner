package org.fancylynx.application.service;

import org.fancylynx.application.DAL.entity.TourLog;
import org.fancylynx.application.DAL.repository.TourLogRepository;
import org.fancylynx.application.model.tourlog.TourLogModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TourLogServiceImpl implements TourLogService{
    private final TourLogRepository tourLogRepository;

    public TourLogServiceImpl(TourLogRepository tourLogRepository) {
        this.tourLogRepository = tourLogRepository;
    }

    @Override
    public List<TourLogModel> getAllTourLogs(long tourId) {
        try {
            return tourLogRepository.findByTourId(tourId)
                    .stream().map(
                            tourLog -> new TourLogModel(
                                    tourLog.getId(),
                                    tourLog.getDate(),
                                    tourLog.getComment(),
                                    tourLog.getDifficulty(),
                                    tourLog.getTotalTime(),
                                    tourLog.getRating()
                            )
                    ).toList();

        } catch (Exception e) {
            System.out.println("Error retrieving tour logs from database: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean createNewTourLog(TourLog tourLog) {
        try {
            tourLogRepository.save(tourLog);
            System.out.println("Tour log saved to database");
            // print the tourlog to the console
            System.out.println(tourLog.toString());
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
