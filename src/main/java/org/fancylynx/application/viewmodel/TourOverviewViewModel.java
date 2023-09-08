package org.fancylynx.application.viewmodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.fancylynx.application.BL.model.tour.TourModel;
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
    private final TourServiceNew tourServiceNew;
    private List<SelectionChangedListener> listeners = new ArrayList<>();
    private ObservableList<TourModel> tourModels = FXCollections.observableArrayList();
    public TourOverviewViewModel(TourServiceNew tourServiceNew) {
        this.tourServiceNew = tourServiceNew;
        setTours(this.tourServiceNew.getAllTours());
    }

    public void setTours(List<TourModel> tourModels) {
        this.tourModels.clear();
        this.tourModels.addAll(tourModels);
    }

    public void addNewTour() {
        var tour = tourServiceNew.createNewTour();
        tourModels.add(tour);

        logger.info("Added new tour with id=[{}]", tour.getTourId());
    }

    public void deleteTour(TourModel tourModel) {
        tourServiceNew.deleteTour(tourModel);
        tourModels.remove(tourModel);

        logger.info("Deleted tour with id=[{}]", tourModel.getTourId());
    }

    public void addTourToList(TourModel tourModel) {
        tourModels.add(tourModel);
    }

    public ObservableList<TourModel> getObservableTours() {
        return tourModels;
    }

    public void addSelectionChangedListener(SelectionChangedListener listener) {
        listeners.add(listener);
    }

    public ChangeListener<TourModel> getChangeListener() {
        return (observableValue, oldValue, newValue) -> notifyListeners(newValue);
    }

    private void notifyListeners(TourModel newValue) {
        for (var listener : listeners) {
            listener.changeSelection(newValue);
        }
    }

    public interface SelectionChangedListener {
        void changeSelection(TourModel tourModel);
    }

}
