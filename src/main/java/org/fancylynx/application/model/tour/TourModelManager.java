package org.fancylynx.application.model.tour;

import org.fancylynx.application.entity.Tour;
import org.fancylynx.application.repository.TourRepository;
import org.fancylynx.application.service.TourService;
import org.springframework.stereotype.Repository;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

@Repository
public class TourModelManager implements TourModel {
    private final TourRepository tourRepository;
    private final PropertyChangeSupport propertyChangeSupport;
    private final TourService tourService;

    public TourModelManager(TourRepository tourRepository, TourService tourService) {
        this.tourService = tourService;
        this.tourRepository = tourRepository;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public void createNewTour(Tour tour) {
        try {
            String sessionId = tourService.getRoute(tour);
            String json = tourService.getStaticMap(sessionId);
            tour.setSessionId(sessionId);
            propertyChangeSupport.firePropertyChange("sessionFire", null, tour.getSessionId());
            tourRepository.save(tour);
        } catch (Exception e) { // 2do
            System.out.println("XXXXXXXXXXXXXXX nah: " + e.getMessage());
        }

//        propertyChangeSupport.firePropertyChange("transportFire", null, tour.getTransportType());


    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
