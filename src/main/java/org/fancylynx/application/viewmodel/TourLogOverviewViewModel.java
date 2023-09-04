package org.fancylynx.application.viewmodel;

import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.DAL.entity.TourLog;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.TourLogService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TourLogOverviewViewModel {
    public interface SelectionChangedListener {
        void changeSelection(TourLogModel tourLogModel);
    }
    private List<SelectionChangedListener> listeners = new ArrayList<>();

    @Getter
    private TourModelNew tour;
    private final TourLogService tourLogService;

    private ObservableList<TourLogModel> tourLogModels = FXCollections.observableArrayList();


    public ObservableList<TourLogModel> getObservableTourLogs() {
        return tourLogModels;
    }

    public void addSelectionChangedListener(SelectionChangedListener listener) {
        listeners.add(listener);
    }

    public ChangeListener<TourLogModel> getChangeListener() {
        return (observableValue, oldValue, newValue) -> notifyListeners(newValue);
    }

    public TourLogOverviewViewModel(TourLogService tourLogService) {
        this.tourLogService = tourLogService;
    }
    public List<TourLogModel> getTourLogModels(Tour tour) {
        return tourLogService.getAllTourLogs(tour.getId());
    }

    private void notifyListeners(TourLogModel newValue) {
        for ( var listener : listeners ) {
            listener.changeSelection(newValue);
        }
    }

    public void setTour(TourModelNew tour) {
        if (tour == null) {
            return;
        }

        this.tour = tour;
        setTourLogs(tourLogService.getAllTourLogs(tour.getTourId()));
    }

    public void setTourLogs(List<TourLogModel> tourLogs) {
        tourLogModels.clear();
        tourLogModels.addAll(tourLogs);
    }

    public void setTourLogModel(TourLogModel tourLogModel) {
    }

    public void addTourLog() {
        var tourLog = tourLogService.createNewTourLog(tour);
        tourLogModels.add(tourLog);
    }

    public void deleteTourLog(TourLogModel tourLog) {
       tourLogService.deleteTourLog(tourLog);
       tourLogModels.remove(tourLog);
    }


}
