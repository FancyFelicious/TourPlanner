package org.fancylynx.application.viewmodel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.DAL.entity.TourLog;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.TourLogService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TourLogOverviewViewModel {
    private final TourLogService tourLogService;

    @Getter
    @Setter
    private ObjectProperty<Tour> tour = new SimpleObjectProperty<>();

    private ObservableList<TourLogModel> tourLogModels = FXCollections.observableArrayList();

    public TourLogOverviewViewModel(TourLogService tourLogService) {
        this.tourLogService = tourLogService;
    }

    public ObservableList<TourLogModel> getObservableTourLogs() {
        return tourLogModels;
    }

    public List<TourLogModel> getTourLogModels(Tour tour) {
        return tourLogService.getAllTourLogs(tour.getId());
    }

    public void setTourLogs(List<TourLogModel> tourLogs) {
        tourLogModels.clear();
        tourLogModels.addAll(tourLogs);
    }

    public void setTourLogModel(TourLogModel tourLogModel) {
    }

    public void saveTourLog() {
        TourLog tourLog = new TourLog();
        /*tourLog.setDate(date.get());
        tourLog.setComment(comment.get());
        tourLog.setDifficulty(difficulty.get());
        tourLog.setTotalTime(totalTime.get());
        tourLog.setRating(rating.get());*/

        TourLogModel tourLogM = tourLogService.createNewTourLog(tourLog);
        tourLogModels.add(tourLogM);
    }

    public void deleteTourLog(TourLogModel tourLog) {
       tourLogService.deleteTourLog(tourLog);
       tourLogModels.remove(tourLog);
    }


    public ObjectProperty<Tour> tourProperty() {
        return tour;
    }
}
