package org.fancylynx.application.BL.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.DAL.repository.TourRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TourServiceImpl implements TourServiceNew {
    private static final Logger logger = LogManager.getLogger(TourServiceImpl.class);
    private final TourRepository tourRepository;

    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public List<TourModelNew> getAllTours() {

        return tourRepository.findAll()
                .stream().map(
                        this::setValues
                ).toList();
    }

    @Override
    public TourModelNew createNewTour() {
        Tour tour = new Tour();
        tour.setTransportType("AUTO");

        try {
            tourRepository.save(tour);
        } catch (Exception e) {
            logger.error("Error while creating new tour", e);
        }

        return setValues(tour);
    }

    @Override
    public void updateTour(TourModelNew tourModel) {
        Optional<Tour> tourOptional = tourRepository.findById(tourModel.getTourId());
        tourOptional.ifPresent(tour -> {
            setValues(tour, tourModel);
            tourRepository.saveAndFlush(tour);
        });
    }

    @Override
    public TourModelNew importTour(TourModelNew tourModel) {
        Tour tour = new Tour();
        setValues(tour, tourModel);
        try {
            tourRepository.saveAndFlush(tour);
        } catch (Exception e) {
            logger.error("Error while importing tour", e);
        }

        return setValues(tour);
    }

    @Override
    public void deleteTour(TourModelNew tourModelNew) {
        tourRepository.deleteById(tourModelNew.getTourId());
    }

    public void setValues(Tour tour, TourModelNew tourModel) {
        tour.setName(tourModel.getName());
        tour.setDescription(tourModel.getDescription());
        tour.setOrigin(tourModel.getFrom());
        tour.setDestination(tourModel.getTo());
        tour.setTransportType(tourModel.getTransportType());
        tour.setDistance(tourModel.getDistance());
        tour.setEstimatedTime(tourModel.getEstimatedTime());
        tour.setImagePath(tourModel.getImagePath());
    }

    public TourModelNew setValues(Tour tour) {
        return new TourModelNew(
                tour.getId(),
                tour.getName(),
                tour.getDescription(),
                tour.getOrigin(),
                tour.getDestination(),
                tour.getTransportType(),
                tour.getDistance(),
                tour.getEstimatedTime(),
                tour.getImagePath()
        );
    }
}
