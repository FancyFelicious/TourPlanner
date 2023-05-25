package org.fancylynx.application.model.tour;


import javafx.beans.property.StringProperty;
import org.fancylynx.application.entity.Tour;
import org.fancylynx.application.repository.TourRepository;
import org.springframework.stereotype.Repository;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

@Repository
public class TourModelManager implements TourModel {
    private final TourRepository tourRepository;
    private final PropertyChangeSupport propertyChangeSupport;

    public TourModelManager(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public void createNewTour(StringProperty tourName) {
        Tour tour = new Tour();
        tour.setName(String.valueOf(tourName));

        try {
            tourRepository.save(tour);
        } catch (Exception e) { // 2do
            System.out.println("XXXXXXXXXXXXXXX nah: " + e.getMessage());
        }

        propertyChangeSupport.firePropertyChange("tourName", null, tour.getName());

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
