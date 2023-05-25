package org.fancylynx.application.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.fancylynx.application.entity.Tour;
import org.fancylynx.application.model.tour.TourModel;
import org.springframework.stereotype.Component;

@Component
public class TourViewModel {
    private final TourModel tourModel;

    // 2do: remove '' from variable/getter/setter names
    private final StringProperty imageDirectory;
    private final StringProperty imageName;
    private final StringProperty name;
    private final StringProperty origin;
    private final StringProperty destination;
    private final StringProperty description;
    private final StringProperty transportType;
    private final StringProperty imageFormat;
    private final StringProperty sessionId;
    private final StringProperty finalImagePath;

    public TourViewModel(TourModel tourModel) {
        this.tourModel = tourModel;
        this.imageDirectory = new SimpleStringProperty();
        this.imageName = new SimpleStringProperty();
        this.imageFormat = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.origin = new SimpleStringProperty();
        this.destination = new SimpleStringProperty();
        this.transportType = new SimpleStringProperty();
        this.sessionId = new SimpleStringProperty();
        this.finalImagePath = new SimpleStringProperty();

        tourModel.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("sessionTokenRetrieved")) {
                setSessionId(evt.getNewValue().toString());
            } else if (evt.getPropertyName().equals("staticMapRetrieved")) {
                setFinalImagePath(evt.getNewValue().toString());
//                System.out.println(evt.getNewValue().toString());
            }
        });
    }

    public StringProperty getFinalImagePath() {
        return finalImagePath;
    }

    public void setFinalImagePath(String finalImagePath) {
        this.finalImagePath.set(finalImagePath);
    }

    public StringProperty getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat.set(imageFormat);
    }

    public StringProperty getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType.set(transportType);
    }

    public void createNewTour() {
        Tour newTour = new Tour();
        newTour.setName(name.get());
        newTour.setDescription(description.get());
        newTour.setOrigin(origin.get());
        newTour.setDestination(destination.get());
        newTour.setTransportType(transportType.get());
        tourModel.createNewTour(newTour);
    }

    public StringProperty getImageDirectory() {
        return imageDirectory;
    }

    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory.set(imageDirectory);
    }

    public StringProperty getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName.set(imageName);
    }

    public StringProperty getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin.set(origin);
    }

    public StringProperty getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
    }

    public StringProperty getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId.set(sessionId);
    }
}
