package org.fancylynx.application.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.fancylynx.application.model.tour.TourModel;
import org.springframework.stereotype.Component;

@Component
public class TourViewModel {//{
    private final TourModel tourModel;
    private final StringProperty TEST_OUTPUT;
    private final StringProperty testTourName;


    public TourViewModel(TourModel tourModel) {
        this.tourModel = tourModel;
        TEST_OUTPUT = new SimpleStringProperty();
        testTourName = new SimpleStringProperty();

        tourModel.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("testTourName")) {
//                setTourName(evt.getNewValue().toString());
//                testTourName.set(evt.getNewValue().toString());
                setTourName(evt.getNewValue().toString());
            }
        });
    }


    public void createNewTour() {
        tourModel.testCreateTour();
//        String testString = "eyoyocoolhatfunktionerthioapsjf";
//        this.testTourName.set(testString);
    }

    public void setTourName(String tourName) {
        this.testTourName.set(tourName);
    }

    public StringProperty testTourNameProperty() {
        return testTourName;
    }

    public void setTEST_OUTPUT(String TEST_OUTPUT) {
        this.TEST_OUTPUT.set(TEST_OUTPUT);
    }

    public StringProperty TEST_OUTPUTProperty() {
        return TEST_OUTPUT;
    }

}
