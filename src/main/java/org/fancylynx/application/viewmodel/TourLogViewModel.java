package org.fancylynx.application.viewmodel;

import javafx.beans.property.*;
import org.fancylynx.application.model.tourlog.TourLogModel;
import org.fancylynx.application.service.TourLogService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TourLogViewModel {
    private final LongProperty tourLogID = new SimpleLongProperty();
    private final ObjectProperty<LocalDateTime> date = new SimpleObjectProperty<>();
    private final StringProperty comment = new SimpleStringProperty();
    private final ObjectProperty<Integer> difficulty = new SimpleObjectProperty<>();
    private final DoubleProperty totalTime = new SimpleDoubleProperty();
    private final ObjectProperty<Integer> rating = new SimpleObjectProperty<>();
    private final TourLogService tourLogService;

    public TourLogViewModel(TourLogService tourLogService) {
        this.tourLogService = tourLogService;
    }
    public long getTourLogID() {
        return tourLogID.get();
    }

    public LongProperty tourLogIDProperty() {
        return tourLogID;
    }

    public void setTourLogID(long tourLogID) {
        this.tourLogID.set(tourLogID);
    }

    public LocalDateTime getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDateTime> dateProperty() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date.set(date);
    }

    public String getComment() {
        return comment.get();
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public Integer getDifficulty() {
        return difficulty.get();
    }

    public ObjectProperty<Integer> difficultyProperty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty.set(difficulty);
    }

    public double getTotalTime() {
        return totalTime.get();
    }

    public DoubleProperty totalTimeProperty() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime.set(totalTime);
    }

    public Integer getRating() {
        return rating.get();
    }

    public ObjectProperty<Integer> ratingProperty() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating.set(rating);
    }

    public void setTourLogModel(TourLogModel tourLogModel) {

    }
}
