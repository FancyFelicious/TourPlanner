package org.fancylynx.application.viewmodel;

import javafx.beans.property.*;
import lombok.Getter;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.TourLogService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
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

    public void setTourLogModel(TourLogModel tourLogModel) {
        this.tourLogModel = tourLogModel;
        tourLogID.set(tourLogModel.getTourLogId());
        date.set(tourLogModel.getDate());
        comment.set(tourLogModel.getComment());
        difficulty.set(tourLogModel.getDifficulty());
        totalTime.set(tourLogModel.getTotalTime());
        rating.set(tourLogModel.getRating());
    }

    public void updateTourLog() {

    }
}
