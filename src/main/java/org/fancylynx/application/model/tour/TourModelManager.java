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
        // Stage 1: Calculate route / get session ID
        try {
            String sessionId = tourService.getRoute(tour);
            propertyChangeSupport.firePropertyChange("sessionTokenRetrieved", null, sessionId);

            // Stage 2: Retrieve map & save to file system
            try {
                String imagePath = tourService.getStaticMap(sessionId);
                tour.setImagePath(imagePath);
                propertyChangeSupport.firePropertyChange("staticMapRetrieved", null, imagePath);

                // Stage 3: Save tour to database
                try {
                    tourRepository.save(tour);
                } catch (Exception e) {
                    System.out.println("Error saving tour to database: " + e.getMessage()); // 2do
                }
            } catch (Exception e) { // 2do
                System.out.println("Error parsing request - unable to retrieve static map:: " + e.getMessage());
            }
        } catch (Exception e) { // 2do
            System.out.println("Error parsing request - unable to retrieve session ID: " + e.getMessage());
        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
