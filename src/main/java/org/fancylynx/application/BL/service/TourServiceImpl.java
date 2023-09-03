package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.DAL.repository.TourRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TourServiceImpl implements TourServiceNew {

    private final TourRepository tourRepository;

    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public List<TourModelNew> getAllTours() {

        return tourRepository.findAll()
                .stream().map(
                        tour -> new TourModelNew(
                                tour.getId(),
                                tour.getName(),
                                tour.getDescription(),
                                tour.getOrigin(),
                                tour.getDestination(),
                                tour.getTransportType(),
                                tour.getDistance(),
                                tour.getEstimatedTime(),
                                tour.getImagePath()
                        )
                ).toList();
    }

    @Override
    public void createNewTour(Tour tour) {
        // TODO Auto-generated method stub

    }
}
