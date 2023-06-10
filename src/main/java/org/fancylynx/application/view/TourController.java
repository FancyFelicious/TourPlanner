package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.fancylynx.application.config.Constants;
import org.fancylynx.application.service.ImageService;
import org.fancylynx.application.viewmodel.TourViewModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//@Component @Controller // 2do
public class TourController {
    @FXML
    TextField imageDirectoryInput;
    @FXML
    Label imageDirectory;

    @FXML
    TextField imageNameInput;
    @FXML
    Label imageName;

    @FXML
    TextField originInput;
    @FXML
    Label origin;

    @FXML
    TextField destinationInput;
    @FXML
    Label destination;

    @FXML
    TextField nameInput;
    @FXML
    Label name;

    @FXML
    TextField descriptionInput;
    @FXML
    Label description;

    @FXML
    ToggleGroup imageFormatToggleGroup;
    @FXML
    RadioButton png;
    @FXML
    RadioButton jpg;
    @FXML
    RadioButton jpeg;
    @FXML
    Label imageFormat;

    @FXML
    ToggleGroup transportTypeToggleGroup;
    @FXML
    RadioButton car;
    @FXML
    RadioButton bicycle;
    @FXML
    RadioButton walking;
    @FXML
    Label transportType;

    @FXML
    Label status;
    @FXML
    Label sessionID;
    @FXML
    Label imagePath;
    @FXML
    ImageView tourMap;

    @FXML
    Button apply;
    @FXML
    Button back;
    @FXML
    Button updateImage;

    private TourViewModel viewModel;
    private ViewHandler viewHandler;

    public TourController() {
    }

    // Note: Init method needed because constructor of controller must be empty
    public void init(TourViewModel tourViewModel, ViewHandler viewHandler) throws FileNotFoundException {
        this.viewModel = tourViewModel;
        this.viewHandler = viewHandler;
        loadConfiguration(); // Remember settings after switching scenes // 2do: necessary?

        // Bind UI elements to view model
        // 2do: remove bidirectional binding? not reall necessar
        // Tour Configuration Preview / Real-time UI updates
        nameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setName(newValue);
        });
        name.textProperty().bind(viewModel.getName());

        descriptionInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setDescription(newValue);
        });
        description.textProperty().bind(viewModel.getDescription());

        originInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setOrigin(newValue);
        });
        origin.textProperty().bind(viewModel.getOrigin());

        destinationInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setDestination(newValue);
        });
        destination.textProperty().bind(viewModel.getDestination());

        imageDirectoryInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setImageDirectory(newValue);
        });
        imageDirectory.textProperty().bind(viewModel.getImageDirectory());

        imageNameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setImageName(newValue);
        });
        imageName.textProperty().bind(viewModel.getImageName());

        imageFormatToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton selectedRadioButton = (RadioButton) imageFormatToggleGroup.getSelectedToggle();
            String selectedValue = selectedRadioButton.getText();
            viewModel.setImageFormat(selectedValue);
        });
        imageFormat.textProperty().bind(viewModel.getImageFormat());

        transportTypeToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton selectedRadioButton = (RadioButton) transportTypeToggleGroup.getSelectedToggle();
            String selectedValue = selectedRadioButton.getText();
            viewModel.setTransportType(selectedValue);
        });
        transportType.textProperty().bind(viewModel.getTransportType());

        // Tour Creation Status (uneditable) - Retrieved from ViewModel / API
        status.textProperty().bind(viewModel.getStatus());
        sessionID.textProperty().bind(viewModel.getSessionId());
        tourMap.imageProperty().bind(viewModel.getTourMap());
        imagePath.textProperty().bind(viewModel.getFinalImagePath());
    }

    @FXML
    public void handleApplyButton() throws IOException { // 2do: exception?
        System.out.println("DEBUG - CLICKED APPLY BUTTON"); // 2do

        // 2do: Check input, duplicate name, etc. (probably in view model)
        viewModel.createNewTour();
    }

    // 2do: delete
    @FXML
    private void handleUpdateImageButton() throws FileNotFoundException {
        System.out.println("updating image");
        Image image = new Image(new FileInputStream("images/tourImage_TEST.png")); //2do
        viewModel.setTourMap(image);
    }

    @FXML
    public void handleBackButton() throws IOException {
        viewHandler.openView(Views.HOME.getFxmlFileName());
    }

    private void loadConfiguration() throws FileNotFoundException {
        // Set toggle groups
        imageFormatToggleGroup = new ToggleGroup();
        png.setToggleGroup(imageFormatToggleGroup);
        jpg.setToggleGroup(imageFormatToggleGroup);
        jpeg.setToggleGroup(imageFormatToggleGroup);
        transportTypeToggleGroup = new ToggleGroup();
        car.setToggleGroup(transportTypeToggleGroup);
        bicycle.setToggleGroup(transportTypeToggleGroup);
        walking.setToggleGroup(transportTypeToggleGroup);

        // Set image settings based on last used/default settings
        RadioButton selectedImageFormat = (RadioButton) imageFormatToggleGroup.getSelectedToggle();
        RadioButton selectedTransportType = (RadioButton) transportTypeToggleGroup.getSelectedToggle();
        imageDirectory.setText(ImageService.imageDirectory);
        imageName.setText(ImageService.imageName);
        switch (ImageService.imageFormat) {
            case Constants.FILE_EXTENSION_JPG -> jpg.setSelected(true);
            case Constants.FILE_EXTENSION_JPEG -> jpeg.setSelected(true);
            default -> png.setSelected(true);
        }
        switch (selectedTransportType.getText()) {
            case Constants.TRANSPORT_TYPE_WALKING -> walking.setSelected(true);
            case Constants.TRANSPORT_TYPE_BICYCLE -> bicycle.setSelected(true);
            default -> car.setSelected(true);
        }

        // Set ViewModel default values (this is only necessary on first load up)
        viewModel.setOrigin(originInput.getText());
        viewModel.setDestination(destinationInput.getText());
        viewModel.setName(nameInput.getText());
        viewModel.setDescription(descriptionInput.getText());
        viewModel.setTransportType(selectedTransportType.getText());
        viewModel.setImageDirectory(imageDirectoryInput.getText());
        viewModel.setImageName(imageNameInput.getText());
        viewModel.setImageFormat(selectedImageFormat.getText());
        viewModel.setStatus("Status: Waiting for new request...");
        viewModel.setTourMap(new Image(new FileInputStream(Constants.DEFAULT_TOUR_MAP_PLACEHOLDER_IMAGE)));
    }
}