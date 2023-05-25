package org.fancylynx.application.model.tour;

import org.fancylynx.application.entity.Tour;

import java.beans.PropertyChangeListener;

//@Component
// 2do
public interface TourModel {

    void createNewTour(Tour tour);

    void addPropertyChangeListener(PropertyChangeListener listener);


//    String getName();
//
//    void setName(String name);
//
//    String getDescription();
//
//    void setDescription(String description);
//
//    String getFrom();
//
//    void setFrom(String from);
//
//    String getTo();
//
//    void setTo(String to);
//
//    String getTransportType();
//
//    void setTransportType(String transportType);
//
//    Double getTourDistance();
//
//    void setTourDistance(Double tourDistance);
//
//    String getEstimatedTime();
//
//    void setEstimatedTime(String estimatedTime);
//
//    String getRouteInformation();
//
//    void setRouteInformation(String routeInformation);


}
