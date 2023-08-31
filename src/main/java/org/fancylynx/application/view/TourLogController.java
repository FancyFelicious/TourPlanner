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
import org.fancylynx.application.viewmodel.TourLogViewModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class TourLogController implements Initializable {
    @FXML
    public ListView<TourLogModel> tourLogTitle;


    @Getter
    private final TourLogViewModel tourLogViewModel;

    public TourLogController(TourLogViewModel tourLogViewModel) {
        this.tourLogViewModel = tourLogViewModel;
    }

    public void handleCreateTourLog() {
        try {
            FXMLLoader loader = FXMLDependencyInjection.getLoader("AddTourLog.fxml", Locale.GERMAN, null);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setTitle("Add Tour Log");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("TourLogController initialized");
        tourLogTitle.setItems(tourLogViewModel.getObservableTourLogs());
        tourLogViewModel.tourProperty().addListener((observable, oldValue, newValue) -> updateTourLogs(newValue));
    }

    private void updateTourLogs(Tour tour) {
        if (tour != null) {
            List<TourLogModel> tourLogs = tourLogViewModel.getTourLogModels(tour);
            tourLogViewModel.setTourLogs(tourLogs);
        }
    }
}
