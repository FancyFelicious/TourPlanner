package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.fancylynx.FXMLDependencyInjection;
import org.fancylynx.application.viewmodel.TourLogViewModel;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class TourLogController implements Initializable {
    @FXML
    public VBox tourLogTitle;


    private final TourLogViewModel tourLogViewModel;

    public TourLogController(TourLogViewModel tourLogViewModel) {
        this.tourLogViewModel = tourLogViewModel;
    }

    public TourLogViewModel getTourLogViewModel() {
        return tourLogViewModel;
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
    }
}
