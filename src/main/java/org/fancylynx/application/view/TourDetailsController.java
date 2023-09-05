package org.fancylynx.application.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.converter.NumberStringConverter;
import org.fancylynx.application.viewmodel.TourDetailsViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class TourDetailsController implements Initializable {

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
    private ChoiceBox<String> transportType;
    @FXML
    private ImageView tourMap;

    private final ObservableList<String> transList = FXCollections.observableArrayList("CAR", "WALK", "CYCLE");
    private TourDetailsViewModel tourDetailsViewModel;

    public TourDetailsController() {
    }

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
        tourDetailsViewModel.saveTour();
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
    }
}
