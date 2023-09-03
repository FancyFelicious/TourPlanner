package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lombok.Getter;
import org.fancylynx.application.BL.model.tour.TourModelNew;

import javafx.scene.control.ListView;
import org.fancylynx.application.viewmodel.TourOverviewViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class TourOverviewController implements Initializable {
    @FXML
    public ListView<TourModelNew> tourList;

    @Getter
    private final TourOverviewViewModel tourOverviewViewModel;

    public TourOverviewController(TourOverviewViewModel tourOverviewViewModel) {
        this.tourOverviewViewModel = tourOverviewViewModel;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("TourOverviewController initialized");
        tourList.setItems(tourOverviewViewModel.getObservableTours());
    }

    public void createTour() {

    }
    public void deleteTour() {

    }
}
