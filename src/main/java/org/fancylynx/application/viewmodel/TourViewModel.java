package org.fancylynx.application.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.fancylynx.application.entity.Tour;
import org.fancylynx.application.model.tour.TourModel;
import org.springframework.stereotype.Component;

@Component
public class TourViewModel {//{
    private final TourModel tourModel;
    private final StringProperty imageDirectoryOutput;
    private final StringProperty imageNameOutput;
    private final StringProperty nameOutput;
    private final StringProperty originOutput;
    private final StringProperty destinationOutput;
    private final StringProperty descriptionOutput;

    public TourViewModel(TourModel tourModel) {
        this.tourModel = tourModel;
        this.imageDirectoryOutput = new SimpleStringProperty();
        this.imageNameOutput = new SimpleStringProperty();
        this.nameOutput = new SimpleStringProperty();
        this.descriptionOutput = new SimpleStringProperty();
        this.originOutput = new SimpleStringProperty();
        this.destinationOutput = new SimpleStringProperty();
        
//        tourModel.addPropertyChangeListener(evt -> {
//            if (evt.getPropertyName().equals("testTourName")) {
////                setTourName(evt.getNewValue().toString());
////                testTourName.set(evt.getNewValue().toString());
//                setTourName(evt.getNewValue().toString());
//            }
//        });
    }

    public void createNewTour() {
        Tour newTour = new Tour();
        newTour.setName(imageNameOutput.get());
        newTour.setDescription(descriptionOutput.get());
        newTour.setOrigin(originOutput.get());
        newTour.setDestination(destinationOutput.get());
        tourModel.createNewTour(newTour);
    }

    public StringProperty getImageDirectoryOutput() {
        return imageDirectoryOutput;
    }

    public void setImageDirectoryOutput(String imageDirectoryOutput) {
        this.imageDirectoryOutput.set(imageDirectoryOutput);
    }

    public StringProperty getImageNameOutput() {
        return imageNameOutput;
    }

    public void setImageNameOutput(String imageNameOutput) {
        this.imageNameOutput.set(imageNameOutput);
    }

    public StringProperty getNameOutput() {
        return nameOutput;
    }

    public void setNameOutput(String nameOutput) {
        this.nameOutput.set(nameOutput);
    }

    public StringProperty getDescriptionOutput() {
        return descriptionOutput;
    }

    public void setDescriptionOutput(String descriptionOutput) {
        this.descriptionOutput.set(descriptionOutput);
    }

    public StringProperty getOriginOutput() {
        return originOutput;
    }

    public void setOriginOutput(String originOutput) {
        this.originOutput.set(originOutput);
    }

    public StringProperty getDestinationOutput() {
        return destinationOutput;
    }

    public void setDestinationOutput(String destinationOutput) {
        this.destinationOutput.set(destinationOutput);
    }
}
