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
import org.fancylynx.application.viewmodel.TourLogDetailsViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class TourLogDetailsController implements Initializable {

    @FXML
    private DatePicker tourLogDate;
    @FXML
    private ChoiceBox<String> diffChoiceBox;
    @FXML
    private TextField tourLogTime;
    @FXML
    private ChoiceBox<Integer> tourLogRating;
    @FXML
    private TextArea tourLogComment;


    private final ObservableList<String> diffList = FXCollections.observableArrayList("EASY", "MEDIUM", "HARD");
    private final ObservableList<Integer> ratingList = FXCollections.observableArrayList(1, 2, 3, 4, 5);
    private TourLogDetailsViewModel tourLogDetailsViewModel;

    public TourLogDetailsController() {
    }

    public TourLogDetailsController(TourLogDetailsViewModel tourLogDetailsViewModel) {
        this.tourLogDetailsViewModel = tourLogDetailsViewModel;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("TourLogDetailsController initialized");
        bindProperties();
        diffChoiceBox.getItems().addAll(diffList);
        diffChoiceBox.getSelectionModel().selectFirst();
        tourLogRating.getItems().addAll(ratingList);
        tourLogRating.getSelectionModel().selectFirst();
    }

    private void bindProperties() {
        tourLogDate.valueProperty().bindBidirectional(tourLogDetailsViewModel.getDate());
        diffChoiceBox.valueProperty().bindBidirectional(tourLogDetailsViewModel.getDifficulty());
        tourLogTime.textProperty().bindBidirectional(tourLogDetailsViewModel.getTotalTime(), new NumberStringConverter());
        tourLogRating.valueProperty().bindBidirectional(tourLogDetailsViewModel.getRating().asObject());
        tourLogComment.textProperty().bindBidirectional(tourLogDetailsViewModel.getComment());
    }
}
