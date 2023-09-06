package org.fancylynx.application.viewmodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.beans.value.ChangeListener;
import java.util.ArrayList;
import java.util.List;

@Component
public class TourOverviewViewModel {
    private static final Logger logger = LogManager.getLogger(TourOverviewViewModel.class);
    public interface SelectionChangedListener {
        void changeSelection(TourModelNew tourModel);
    }

    private List<SelectionChangedListener> listeners = new ArrayList<>();
    private ObservableList<TourModelNew> tourModels = FXCollections.observableArrayList();
    private final TourServiceNew tourServiceNew;

    public TourOverviewViewModel(TourServiceNew tourServiceNew) {
        this.tourServiceNew = tourServiceNew;
        setTours(this.tourServiceNew.getAllTours());
    }

    public void setTours(List<TourModelNew> tourModels) {
        this.tourModels.clear();
        this.tourModels.addAll(tourModels);
    }

    public void addNewTour() {
        var tour = tourServiceNew.createNewTour();
        tourModels.add(tour);
    }

    public TourModelNew importTour(TourModelNew tourModel) {
        return tourServiceNew.importTour(tourModel);
    }

    public void deleteTour(TourModelNew tourModel) {
        tourServiceNew.deleteTour(tourModel);
        tourModels.remove(tourModel);
    }

    public void addTourToList(TourModelNew tourModel) {
        tourModels.add(tourModel);
    }

    public ObservableList<TourModelNew> getObservableTours() {
        return tourModels;
    }

    public void addSelectionChangedListener(SelectionChangedListener listener) {
        listeners.add(listener);
    }

    public ChangeListener<TourModelNew> getChangeListener() {
        return (observableValue, oldValue, newValue) -> notifyListeners(newValue);
    }

    private void notifyListeners(TourModelNew newValue) {
        for ( var listener : listeners ) {
            listener.changeSelection(newValue);
        }
    }

}
