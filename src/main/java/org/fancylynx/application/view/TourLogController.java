package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.fancylynx.application.viewmodel.TourLogViewModel;

import java.io.IOException;

public class TourLogController {
    @FXML
    public VBox tourLogTitle;


    private final TourLogViewModel tourLogViewModel;

    public TourLogController(TourLogViewModel tourLogViewModel) {
        this.tourLogViewModel = tourLogViewModel;
    }

    public TourLogViewModel getTourLogViewModel() {
        return tourLogViewModel;
    }


    @FXML
    public void initialize() {
        System.out.println("TourLogController initialized");
    }


    public void handleCreateTourLog() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AddTourLog.fxml"));

            Scene scene = new Scene(loader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Add Tour Log");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
