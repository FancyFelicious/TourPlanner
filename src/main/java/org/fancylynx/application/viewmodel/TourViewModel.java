package org.fancylynx.application.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import org.fancylynx.application.entity.Tour;
import org.fancylynx.application.model.tour.TourModel;
import org.fancylynx.application.service.ImageService;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Component
public class TourViewModel {
    private final TourModel tourModel;
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
    private final StringProperty status;
    private final ObjectProperty<Image> tourMap;

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
        this.status = new SimpleStringProperty();
        this.tourMap = new SimpleObjectProperty<>();

        tourModel.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("sessionTokenRetrieved")) {
                setSessionId(evt.getNewValue().toString());
                setStatus("SESH TOKEN RECEIVED");
            } else if (evt.getPropertyName().equals("staticMapRetrieved")) {
                setFinalImagePath(evt.getNewValue().toString());
                setStatus("MAP RETRIEVED");
                try {
                    Image image = new Image(new FileInputStream(evt.getNewValue().toString())); //2do
                    setTourMap(image);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public ObjectProperty<Image> getTourMap() {
        return tourMap;
    }

    public void setTourMap(Image tourMap) {
        this.tourMap.set(tourMap);
    }

    public StringProperty getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
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
        this.setStatus("PROCESSING REQUEST");
        Tour newTour = new Tour();
        ImageService.imageFormat = imageFormat.get();
        ImageService.imageDirectory = imageDirectory.get();
        ImageService.imageName = imageName.get();
        newTour.setName(name.get());
        newTour.setDescription(description.get());
        newTour.setOrigin(origin.get());
        newTour.setDestination(destination.get());
        newTour.setTransportType(transportType.get());

        System.out.println("XXXXXXXXXXXX DEBUG XXXXXXXXXXXXX");
        System.out.println("Origin: " + newTour.getOrigin());
        System.out.println("Destination: " + newTour.getDestination());
        System.out.println("Name: " + newTour.getName());
        System.out.println("Description: " + newTour.getDescription());
        System.out.println("Transport Type: " + newTour.getTransportType());
        System.out.println("IMG Directory: " + ImageService.imageDirectory);
        System.out.println("IMG Name: " + ImageService.imageName);
        System.out.println("IMG Format: " + ImageService.imageFormat);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");

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
