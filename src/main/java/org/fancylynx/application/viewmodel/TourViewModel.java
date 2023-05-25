package org.fancylynx.application.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.fancylynx.application.model.tour.TourModel;
import org.springframework.stereotype.Component;

@Component
public class TourViewModel {//{
    private final TourModel tourModel;
    private final StringProperty tourNameOutput;
    //    private final StringProperty TEST_OUTPUT;


    public TourViewModel(TourModel tourModel) {
        this.tourModel = tourModel;
        tourNameOutput = new SimpleStringProperty();
        //        TEST_OUTPUT = new SimpleStringProperty();


//        tourModel.addPropertyChangeListener(evt -> {
//            if (evt.getPropertyName().equals("testTourName")) {
////                setTourName(evt.getNewValue().toString());
////                testTourName.set(evt.getNewValue().toString());
//                setTourName(evt.getNewValue().toString());
//            }
//        });
    }


    public void createNewTour() {
//        String newTourName = Configuration.getTourName();
        tourModel.createNewTour(tourNameOutput);
    }


    public StringProperty getTourNameOutput() {
        return tourNameOutput;
    }

    public void setTourNameOutput(String tourNameOutput) {
        this.tourNameOutput.set(tourNameOutput);
    }

//    public void setTEST_OUTPUT(String TEST_OUTPUT) {
//        this.TEST_OUTPUT.set(TEST_OUTPUT);
//    }
//    public StringProperty TEST_OUTPUTProperty() {
//        return TEST_OUTPUT;
//    }

}
