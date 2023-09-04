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
    public TourModelNew createNewTour() {
        // TODO Auto-generated method stub
        Tour tour = new Tour();
        tourRepository.saveAndFlush(tour);
        tour.setName("Tour " + tour.getId());
        tourRepository.saveAndFlush(tour);
        System.out.println("Tour saved to database" + tour.getId());

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

    @Override
    public void deleteTour(TourModelNew tourModelNew) {
        tourRepository.deleteById(tourModelNew.getTourId());
    }
}
