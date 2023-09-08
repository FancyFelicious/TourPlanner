package org.fancylynx.application.BL.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(TourLogServiceImpl.class);
    private final TourLogRepository tourLogRepository;

    public TourLogServiceImpl(TourLogRepository tourLogRepository) {
        this.tourLogRepository = tourLogRepository;
    }

    @Override
    public List<TourLogModel> getAllTourLogs(long tourId) {
        try {
            return tourLogRepository.findByTourId(tourId)
                    .stream().map(
                            this::setTourLogValues
                    ).toList();

        } catch (Exception e) {
            logger.error("Error while getting all tour logs from database", e);
        }
        return null;
    }

    @Override
    public TourLogModel createNewTourLog(TourModelNew tourModel) {
        Tour tour = setTourValues(tourModel);

        TourLog tourLog = new TourLog(tour);

        try {
            tourLogRepository.save(tourLog);

            return setTourLogValues(tourLog);
        } catch (Exception e) {
            logger.error("Error while creating new tour log", e);
        }

        return null;
    }

    @Override
    public void deleteTourLog(TourLogModel tourLog) {
        try {
            tourLogRepository.deleteById(tourLog.getTourLogId());
        } catch (Exception e) {
            logger.error("Error while deleting tour log", e);
        }
    }

    @Override
    public void importTourLog(TourLogModel tourLogModel, TourModelNew tourModel) {
        Tour tour = setTourValues(tourModel);
        TourLog tourlog = new TourLog(tour);

        try {
            tourLogRepository.saveAndFlush(tourlog);
            tourLogRepository.saveAndFlush(setValues(tourlog, tourLogModel));
        } catch (Exception e) {
            logger.error("Error while importing tour log", e);
        }
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


    public TourLog setValues(TourLog tourLog, TourLogModel tourLogModel) {
        tourLog.setDate(tourLogModel.getDate());
        tourLog.setComment(tourLogModel.getComment());
        tourLog.setDifficulty(tourLogModel.getDifficulty());
        tourLog.setTotalTime(tourLogModel.getTotalTime());
        tourLog.setRating(tourLogModel.getRating());

        return tourLog;
    }

    public Tour setTourValues(TourModelNew tourModel) {
        return new Tour(
                tourModel.getTourId(),
                tourModel.getName(),
                tourModel.getDescription(),
                tourModel.getFrom(),
                tourModel.getTo(),
                tourModel.getTransportType(),
                tourModel.getDistance(),
                tourModel.getEstimatedTime(),
                tourModel.getImagePath());
    }

    public TourLogModel setTourLogValues(TourLog tourLog) {
        return new TourLogModel(
                tourLog.getId(),
                tourLog.getDate(),
                tourLog.getComment(),
                tourLog.getDifficulty(),
                tourLog.getTotalTime(),
                tourLog.getRating()
        );
    }
}
