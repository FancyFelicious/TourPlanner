package org.fancylynx.application.model.tour;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.fancylynx.application.entity.Tour;
import org.fancylynx.application.repository.TourRepository;
import org.springframework.stereotype.Repository;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

@Repository
public class TourModelManager implements TourModel {
    private final PropertyChangeSupport propertyChangeSupport;

    private final TourRepository tourRepository;
    private final StringProperty tourNameTest = new SimpleStringProperty();
    private Tour tour;

    public TourModelManager(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

//    @Autowired
//    public void setTourRepository(TourRepository tourRepository) {
//        this.tourRepository = tourRepository;
//    }

    @Override
    public void testCreateTour() {
        tour = new Tour();
        tour.setName("testName3333333333333333333333333");
        tourRepository.save(tour);
//        tourService.saveTest();

        propertyChangeSupport.firePropertyChange("testTourName", null, tour.getName());

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
