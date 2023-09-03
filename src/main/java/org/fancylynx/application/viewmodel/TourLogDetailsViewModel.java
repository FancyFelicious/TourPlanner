package org.fancylynx.application.viewmodel;

import javafx.beans.property.*;
import lombok.Getter;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.TourLogService;

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
    private final IntegerProperty rating = new SimpleIntegerProperty();

    private TourLogService tourLogService;
    private TourLogModel tourLogModel;

    public TourLogDetailsViewModel(TourLogService tourLogService) {
        this.tourLogService = tourLogService;
    }

    public void saveTourLog() {

    }

    public void updateTourLog() {

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

    public IntegerProperty ratingProperty() {
        return rating;
    }
}
