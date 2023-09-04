package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.DAL.repository.TourRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        //tourRepository.saveAndFlush(tour);
        //tour.setName("Tour " + tour.getId());
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
    public void updateTour(TourModelNew tourModel) {
        Optional<Tour> tourOptional = tourRepository.findById(tourModel.getTourId());
        tourOptional.ifPresent(tour -> {
            tour.setName(tourModel.getName());
            tour.setDescription(tourModel.getDescription());
            tour.setOrigin(tourModel.getFrom());
            tour.setDestination(tourModel.getTo());
            tour.setTransportType(tourModel.getTransportType());
            tour.setDistance(tourModel.getDistance());
            tour.setEstimatedTime(tourModel.getEstimatedTime());
            tour.setImagePath(tourModel.getImagePath());
            tourRepository.saveAndFlush(tour);
        });
    }

    @Override
    public void deleteTour(TourModelNew tourModelNew) {
        tourRepository.deleteById(tourModelNew.getTourId());
    }
}
