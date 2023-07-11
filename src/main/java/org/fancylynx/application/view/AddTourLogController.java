package org.fancylynx.application.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import org.fancylynx.application.viewmodel.TourLogViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTourLogController implements Initializable {

    @FXML
    private ChoiceBox<String> diffChoiceBox;

    private final ObservableList<String> diffList = FXCollections.observableArrayList("EASY", "MEDIUM", "HARD");
    private TourLogViewModel tourLogViewModel;

    public AddTourLogController() {
    }

    public void setTourLogViewModel(TourLogViewModel tourLogViewModel) {
        this.tourLogViewModel = tourLogViewModel;
    }

    public AddTourLogController(TourLogViewModel tourLogViewModel) {
        this.tourLogViewModel = tourLogViewModel;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("AddTourLogController initialized");
        bindProperties();
        diffChoiceBox.getItems().addAll(diffList);
        diffChoiceBox.getSelectionModel().selectFirst();
    }

    private void bindProperties() {
        diffChoiceBox.valueProperty().bindBidirectional(tourLogViewModel.getDifficulty());
    }
}
