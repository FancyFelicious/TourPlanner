package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.DAL.entity.TourLog;
import org.fancylynx.application.DAL.repository.TourLogRepository;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public TourLogModel createNewTourLog(TourModelNew tourModel) {
        Tour tour = new Tour(
                tourModel.getTourId(),
                tourModel.getName(),
                tourModel.getDescription(),
                tourModel.getFrom(),
                tourModel.getTo(),
                tourModel.getTransportType(),
                tourModel.getDistance(),
                tourModel.getEstimatedTime(),
                tourModel.getImagePath()
        );

        TourLog tourLog = new TourLog(tour);

        try {
            tourLogRepository.save(tourLog);
            System.out.println("Tour log saved to database");
            // print the tourlog to the console
            System.out.println(tourLog);

            return new TourLogModel(
                    tourLog.getId(),
                    tourLog.getDate(),
                    tourLog.getComment(),
                    tourLog.getDifficulty(),
                    tourLog.getTotalTime(),
                    tourLog.getRating()
            );
        } catch (Exception e) {
            System.out.println("Error saving tour log to database: " + e.getMessage());
        }

        return null;
    }

    @Override
    public Boolean deleteTourLog(TourLogModel tourLog) {
        try {
            tourLogRepository.deleteById(tourLog.getTourLogId());
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting tour log from database: " + e.getMessage());
        }
        return false;
    }

    @Override
    public void updateTourLog(TourLogModel tourLog) {
        Optional<TourLog> tourLogOpt = tourLogRepository.findById(tourLog.getTourLogId());
        tourLogOpt.ifPresent(tourLogEntity -> {
            tourLogEntity.setDate(tourLog.getDate());
            tourLogEntity.setComment(tourLog.getComment());
            tourLogEntity.setDifficulty(tourLog.getDifficulty());
            tourLogEntity.setTotalTime(tourLog.getTotalTime());
            tourLogEntity.setRating(tourLog.getRating());
            tourLogRepository.saveAndFlush(tourLogEntity);
        });

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
