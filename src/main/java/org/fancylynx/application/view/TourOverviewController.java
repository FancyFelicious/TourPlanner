package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import org.fancylynx.FXMLDependencyInjection;
import org.fancylynx.application.BL.model.tour.TourModelNew;

import javafx.scene.control.ListView;
import org.fancylynx.application.viewmodel.TourOverviewViewModel;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
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
        tourList.getSelectionModel().selectedItemProperty().addListener(tourOverviewViewModel.getChangeListener());
    }

    public void createTour() {
        tourOverviewViewModel.addNewTour();
        tourList.getSelectionModel().selectLast();
    }
    public void deleteTour() {
        tourOverviewViewModel.deleteTour(tourList.getSelectionModel().getSelectedItem());
    }
}
