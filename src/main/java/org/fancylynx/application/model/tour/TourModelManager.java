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
            String jpeg = tourService.getStaticMap(sessionId);
            tour.setSessionId(sessionId);
            tourRepository.save(tour);
        } catch (Exception e) { // 2do
            System.out.println("XXXXXXXXXXXXXXX nah: " + e.getMessage());
        }

        propertyChangeSupport.firePropertyChange("transportFire", null, tour.getTransportType());
        propertyChangeSupport.firePropertyChange("sessionFire", null, tour.getSessionId());

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}


//
////
////    // get request
////    // parse
////    // create tour object
////    // set values set by user (to, from etc.) on object
////    // make api request
////    // if successful: call repository to save object to db
////    // return response to controller
////    // controller updates ui based on response
////}
