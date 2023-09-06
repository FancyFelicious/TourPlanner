package org.fancylynx.application.viewmodel;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.TourLogService;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Component
public class TourLogOverviewViewModel {
    private static final Logger logger = LogManager.getLogger(TourLogOverviewViewModel.class);
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

    private void notifyListeners(TourLogModel newValue) {
        for ( var listener : listeners ) {
            listener.changeSelection(newValue);
        }
    }

    public void setTour(TourModelNew tour) {
        if (tour == null) {
            tourLogModels.clear();
            return;
        }

        this.tour = tour;
        setTourLogs(getTourLogs(tour.getTourId()));
    }

    public List<TourLogModel> getTourLogs(long tourId) {
        return tourLogService.getAllTourLogs(tourId);
    }

    public void setTourLogs(List<TourLogModel> tourLogs) {
        tourLogModels.clear();
        tourLogModels.addAll(tourLogs);
    }

    public void addTourLog() {
        var tourLog = tourLogService.createNewTourLog(tour);
        tourLogModels.add(tourLog);
    }

    public void deleteTourLog(TourLogModel tourLog) {
       tourLogService.deleteTourLog(tourLog);
       tourLogModels.remove(tourLog);
    }

    public void importTourLog(TourLogModel tourLogModel, TourModelNew tourModel) {
        tourLogService.importTourLog(tourLogModel, tourModel);
    }

}
