package org.fancylynx.application.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;
import org.fancylynx.application.viewmodel.TourDetailsViewModel;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TourDetailsController implements Initializable {

    private final ObservableList<String> transList = FXCollections.observableArrayList("AUTO", "WALKING", "BICYCLE");
    private final TourDetailsViewModel tourDetailsViewModel;
    @FXML
    private Label tourEstTime;
    @FXML
    private TextField tourName;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    @FXML
    private TextField tourDesc;
    @FXML
    private Label distance;
    @FXML
    private Label imagePath;
    @FXML
    private Label popularity;
    @FXML
    private Label childFriendly;
    @FXML
    private Label statusMessage;
    @FXML
    private ChoiceBox<String> transportType;
    @FXML
    private ImageView tourMap;

    public TourDetailsController(TourDetailsViewModel tourDetailsViewModel) {
        this.tourDetailsViewModel = tourDetailsViewModel;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindProperties();

        transportType.getItems().addAll(transList);
        transportType.getSelectionModel().selectFirst();
    }

    public void saveTour() {

        if (validateInput()) {
            statusMessage.setTextFill(Color.color(1, 1, 1));
            statusMessage.setText("Calculating route...");
            tourDetailsViewModel.saveTour();
            statusMessage.setText("Request processed");
        }
    }

    private Boolean validateInput() {
        boolean isValidInput = true;
        String newStatusMessage = "";

        // Check for empty input
        if (tourName.textProperty().getValue() == null || tourName.textProperty().getValue().trim().isEmpty()) {
            newStatusMessage = "'Tour Name' must not be empty";
            isValidInput = false;
        }
        if (from.textProperty().getValue() == null || from.textProperty().getValue().trim().isEmpty()) {
            newStatusMessage = "'Origin' must not be empty";
            isValidInput = false;
        }
        if (to.textProperty().getValue() == null || to.textProperty().getValue().trim().isEmpty()) {
            newStatusMessage = "'Destination' must not be empty";
            isValidInput = false;
        }

        if (isValidInput) {
            // Create pattern, check for special characters and numbers (only letters allowed for origin and destination)
            Pattern pattern = Pattern.compile("^[a-zA-ZäÄöÖüÜ]+$");
            Matcher validateFrom = pattern.matcher(from.textProperty().getValue());
            Matcher validateTo = pattern.matcher(to.textProperty().getValue());

            if (!(validateFrom.matches() && validateTo.matches())) {
                newStatusMessage = "Origin and destination must not contain numbers or special characters";
                isValidInput = false;
            }
        }

        if (!isValidInput) {
            statusMessage.setTextFill(Color.color(1, 0, 0));
            statusMessage.setText(newStatusMessage);
        }

        return isValidInput;
    }

    public void bindProperties() {
        tourName.textProperty().bindBidirectional(tourDetailsViewModel.getName());
        tourEstTime.textProperty().bindBidirectional(tourDetailsViewModel.getEstimatedTime(), new NumberStringConverter());
        from.textProperty().bindBidirectional(tourDetailsViewModel.getFrom());
        to.textProperty().bindBidirectional(tourDetailsViewModel.getTo());
        tourDesc.textProperty().bindBidirectional(tourDetailsViewModel.getDescription());
        distance.textProperty().bindBidirectional(tourDetailsViewModel.getDistance(), new NumberStringConverter());
        imagePath.textProperty().bindBidirectional(tourDetailsViewModel.getImagePath());
        transportType.valueProperty().bindBidirectional(tourDetailsViewModel.getType());
        tourMap.imageProperty().bindBidirectional(tourDetailsViewModel.getTourMap());
        popularity.textProperty().bindBidirectional(tourDetailsViewModel.getPopularity());
        childFriendly.textProperty().bindBidirectional(tourDetailsViewModel.getChildFriendly());
    }
}
