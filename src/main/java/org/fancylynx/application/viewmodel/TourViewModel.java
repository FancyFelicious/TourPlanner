package org.fancylynx.application.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import lombok.Getter;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.BL.service.ImageService;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Check input etc
 */

@Component
public class TourViewModel {
    @Getter
    private final StringProperty imageDirectory = new SimpleStringProperty();
    @Getter
    private final StringProperty imageName = new SimpleStringProperty();
    @Getter
    private final StringProperty name = new SimpleStringProperty();
    @Getter
    private final StringProperty origin = new SimpleStringProperty();
    @Getter
    private final StringProperty destination = new SimpleStringProperty();
    @Getter
    private final StringProperty description = new SimpleStringProperty();
    // 2do
    @Getter
    private final StringProperty transportType = new SimpleStringProperty();
    @Getter
    private final StringProperty imageFormat = new SimpleStringProperty();
    @Getter
    private final StringProperty sessionId = new SimpleStringProperty();
    @Getter
    private final StringProperty finalImagePath = new SimpleStringProperty();
    @Getter
    private final StringProperty status = new SimpleStringProperty();
    // 2do: order / standardize
    @Getter
    private final ObjectProperty<Image> tourMap = new SimpleObjectProperty<>();

    private TourServiceNew tourServiceNew;

    public TourViewModel(TourServiceNew tourService) {
        this.tourServiceNew = tourService;
    }


    public void createNewTour() {
        this.setStatus("Processing Request...");
        Tour newTour = new Tour();
        newTour.setName(name.get());
        newTour.setDescription(description.get());
        newTour.setOrigin(origin.get());
        newTour.setDestination(destination.get());
        newTour.setTransportType(transportType.get());
        ImageService.imageFormat = imageFormat.get(); //2do: make service private again? / put all params into tour object?
        ImageService.imageFormat = imageFormat.get(); //2do: make service private again? / put all params into tour object?
        ImageService.imageDirectory = imageDirectory.get();
        ImageService.imageName = imageName.get();

        //tourModel.createNewTour(newTour);
    }

    public void setTourMap(Image tourMap) {
        this.tourMap.set(tourMap);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public void setFinalImagePath(String finalImagePath) {
        this.finalImagePath.set(finalImagePath);
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat.set(imageFormat);
    }

    public void setTransportType(String transportType) {
        this.transportType.set(transportType);
    }

    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory.set(imageDirectory);
    }

    public void setImageName(String imageName) {
        this.imageName.set(imageName);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public void setOrigin(String origin) {
        this.origin.set(origin);
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
    }

    public void setSessionId(String sessionId) {
        this.sessionId.set(sessionId);
    }
}

//        System.out.println("XXXXXXXXXXXX DEBUG XXXXXXXXXXXXX");
//        System.out.println("Origin: " + newTour.getOrigin());
//        System.out.println("Destination: " + newTour.getDestination());
//        System.out.println("Name: " + newTour.getName());
//        System.out.println("Description: " + newTour.getDescription());
//        System.out.println("Transport Type: " + newTour.getTransportType());
//        System.out.println("IMG Directory: " + ImageService.imageDirectory);
//        System.out.println("IMG Name: " + ImageService.imageName);
//        System.out.println("IMG Format: " + ImageService.imageFormat);
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");