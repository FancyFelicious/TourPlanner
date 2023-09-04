package org.fancylynx.application.viewmodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.springframework.stereotype.Component;

import javafx.beans.value.ChangeListener;
import java.util.ArrayList;
import java.util.List;

@Component
public class TourOverviewViewModel {
    public interface SelectionChangedListener {
        void changeSelection(TourModelNew tourModel);
    }

    private List<SelectionChangedListener> listeners = new ArrayList<>();
    private ObservableList<TourModelNew> tourModels = FXCollections.observableArrayList();
    private final TourServiceNew tourServiceNew;

    public TourOverviewViewModel(TourServiceNew tourServiceNew) {
        this.tourServiceNew = tourServiceNew;
        setTours(this.tourServiceNew.getAllTours());
        List<TourModelNew> t1 = tourServiceNew.getAllTours();
        System.out.println("\n\n\nt1: " + t1);
    }

    public void setTours(List<TourModelNew> tourModels) {
        this.tourModels.clear();
        this.tourModels.addAll(tourModels);
    }

    public void addNewTour() {
        var tour = tourServiceNew.createNewTour();
        tourModels.add(tour);
    }

    public void deleteTour(TourModelNew tourModel) {
        tourServiceNew.deleteTour(tourModel);
        tourModels.remove(tourModel);
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
