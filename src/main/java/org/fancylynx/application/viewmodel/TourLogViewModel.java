package org.fancylynx.application.viewmodel;

import javafx.beans.property.*;
import lombok.Getter;
import org.fancylynx.application.model.tourlog.TourLogModel;
import org.fancylynx.application.service.TourLogService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TourLogViewModel {
    @Getter
    private final LongProperty tourLogID = new SimpleLongProperty();
    @Getter
    private final ObjectProperty<LocalDateTime> date = new SimpleObjectProperty<>();
    @Getter
    private final StringProperty comment = new SimpleStringProperty();
    @Getter
    private final StringProperty difficulty = new SimpleStringProperty("");
    @Getter
    private final DoubleProperty totalTime = new SimpleDoubleProperty();
    @Getter
    private final ObjectProperty<Integer> rating = new SimpleObjectProperty<>();
    private final TourLogService tourLogService;

    public TourLogViewModel(TourLogService tourLogService) {
        this.tourLogService = tourLogService;
    }

    public void setTourLogModel(TourLogModel tourLogModel) {
    }

    public LongProperty tourLogIDProperty() {
        return tourLogID;
    }

    public ObjectProperty<LocalDateTime> dateProperty() {
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

    public ObjectProperty<Integer> ratingProperty() {
        return rating;
    }


}
