package org.fancylynx.application.viewmodel;

import javafx.beans.property.*;
import lombok.Getter;

import java.time.LocalDate;

public class TourLogDetailsViewModel {

    @Getter
    private final LongProperty tourLogID = new SimpleLongProperty();
    @Getter
    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    @Getter
    private final StringProperty comment = new SimpleStringProperty();
    @Getter
    private final StringProperty difficulty = new SimpleStringProperty("");
    @Getter
    private final DoubleProperty totalTime = new SimpleDoubleProperty();
    @Getter
    private final StringProperty rating = new SimpleStringProperty("");

    public TourLogDetailsViewModel() {
    }


    public LongProperty tourLogIDProperty() {
        return tourLogID;
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public StringProperty difficultyProperty() {
        return difficulty;
    }

    public DoubleProperty totalTimeProperty() {
        return totalTime;
    }

    public StringProperty ratingProperty() {
        return rating;
    }
}
