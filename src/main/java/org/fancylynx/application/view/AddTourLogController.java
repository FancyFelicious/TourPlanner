package org.fancylynx.application.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import org.fancylynx.application.viewmodel.TourLogViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTourLogController implements Initializable {

    @FXML
    private DatePicker tourLogDate;
    @FXML
    private ChoiceBox<String> diffChoiceBox;
    @FXML
    private TextField tourLogTime;
    @FXML
    private TextField tourLogRating;
    @FXML
    private TextArea tourLogComment;

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
        tourLogDate.valueProperty().bindBidirectional(tourLogViewModel.getDate());
        diffChoiceBox.valueProperty().bindBidirectional(tourLogViewModel.getDifficulty());
        tourLogTime.textProperty().bindBidirectional(tourLogViewModel.getTotalTime(), new NumberStringConverter());
        tourLogRating.textProperty().bindBidirectional(tourLogViewModel.getRating(), new NumberStringConverter());
        tourLogComment.textProperty().bindBidirectional(tourLogViewModel.getComment());
    }

    @FXML
    public void handleAddTourLogButton() {
        tourLogViewModel.saveTourLog();
    }

    @FXML
    public void handleDeleteTourLogButton() {
        tourLogViewModel.deleteTourLog();
    }
}
