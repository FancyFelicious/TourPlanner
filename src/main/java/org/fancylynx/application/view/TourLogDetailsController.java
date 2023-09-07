package org.fancylynx.application.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.converter.NumberStringConverter;
import org.controlsfx.control.Rating;
import org.fancylynx.application.viewmodel.TourLogDetailsViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class TourLogDetailsController implements Initializable {

    @FXML
    private DatePicker tourLogDate;
    @FXML
    private Slider difficulty;
    @FXML
    private TextField tourLogTime;
    @FXML
    private Rating tourLogRating;
    @FXML
    private TextArea tourLogComment;


    private TourLogDetailsViewModel tourLogDetailsViewModel;

    public TourLogDetailsController() {
    }

    public TourLogDetailsController(TourLogDetailsViewModel tourLogDetailsViewModel) {
        this.tourLogDetailsViewModel = tourLogDetailsViewModel;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindProperties();
    }

    public void saveTourLog() {
        tourLogDetailsViewModel.saveTourLog();
    }

    private void bindProperties() {
        tourLogDate.valueProperty().bindBidirectional(tourLogDetailsViewModel.getDate());

        difficulty.valueProperty().bindBidirectional(tourLogDetailsViewModel.getDifficulty());
        tourLogTime.textProperty().bindBidirectional(tourLogDetailsViewModel.getTotalTime(), new NumberStringConverter());
        tourLogRating.ratingProperty().bindBidirectional(tourLogDetailsViewModel.getRating());
        tourLogComment.textProperty().bindBidirectional(tourLogDetailsViewModel.getComment());
    }
}
