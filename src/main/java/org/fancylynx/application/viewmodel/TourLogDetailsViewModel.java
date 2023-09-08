package org.fancylynx.application.viewmodel;

import javafx.beans.property.*;
import lombok.Getter;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.TourLogService;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

@Component
public class TourLogDetailsViewModel {
    private static final Logger logger = LogManager.getLogger(TourLogDetailsViewModel.class);

    @Getter
    private final LongProperty tourLogID = new SimpleLongProperty();
    @Getter
    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    @Getter
    private final StringProperty comment = new SimpleStringProperty();
    @Getter
    private final IntegerProperty difficulty = new SimpleIntegerProperty();
    @Getter
    private final DoubleProperty totalTime = new SimpleDoubleProperty();
    @Getter
    private final IntegerProperty rating = new SimpleIntegerProperty();

    private final TourLogService tourLogService;
    private TourLogModel tourLogModel;

    public TourLogDetailsViewModel(TourLogService tourLogService) {
        this.tourLogService = tourLogService;
    }

    public void setTourLogModel(TourLogModel tourLog) {
        if (tourLog == null) {
            resetValues();
            return;
        }

        this.tourLogModel = tourLog;

        tourLogID.set(tourLog.getTourLogId());
        date.set(tourLog.getDate());
        comment.set(tourLog.getComment());
        difficulty.set(tourLog.getDifficulty());
        totalTime.set(tourLog.getTotalTime());
        rating.set(tourLog.getRating());
    }

    public void saveTourLog() {
        setValues();
        tourLogService.updateTourLog(tourLogModel);
    }

    public void resetValues() {
        date.set(LocalDate.now());
        comment.set("");
        difficulty.set(5);
        totalTime.set(0);
        rating.set(1);
    }

    public void setValues() {
        tourLogModel.setDate(date.get());
        tourLogModel.setComment(comment.get());
        tourLogModel.setDifficulty(difficulty.get());
        tourLogModel.setTotalTime(totalTime.get());
        tourLogModel.setRating(rating.get());
    }

    // TODO: Refresh tour list after adding tour log?
}
