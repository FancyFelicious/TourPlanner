package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import lombok.Getter;
import org.fancylynx.FXMLDependencyInjection;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.viewmodel.TourLogOverviewViewModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class TourLogOverviewController implements Initializable {
    @FXML
    public ListView<TourLogModel> tourLogList;


    @Getter
    private final TourLogOverviewViewModel tourLogOverviewViewModel;

    public TourLogOverviewController(TourLogOverviewViewModel tourLogOverviewViewModel) {
        this.tourLogOverviewViewModel = tourLogOverviewViewModel;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("TourLogController initialized");
        tourLogList.setItems(tourLogOverviewViewModel.getObservableTourLogs());
        tourLogList.getSelectionModel().selectedItemProperty().addListener(tourLogOverviewViewModel.getChangeListener());
        //tourLogOverviewViewModel.tourProperty().addListener((observable, oldValue, newValue) -> updateTourLogs(newValue));
    }

    public void handleCreateTourLog() {
        tourLogOverviewViewModel.addTourLog();
    }

    public void deleteTourLog() {
        //tourLogOverviewViewModel.deleteTourLog(tourLogTitle.getSelectionModel().getSelectedItem());
    }
    private void updateTourLogs(Tour tour) {
        if (tour != null) {
            List<TourLogModel> tourLogs = tourLogOverviewViewModel.getTourLogModels(tour);
            tourLogOverviewViewModel.setTourLogs(tourLogs);
        }
    }
}
