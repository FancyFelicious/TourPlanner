package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.fancylynx.application.config.Configuration;
import org.fancylynx.application.config.Constants;
import org.fancylynx.application.viewmodel.TourViewModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//@Component @Controller
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
    ToggleGroup formatToggleGroup;
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
    RadioButton walk;
    @FXML
    Label transportType;

    @FXML
    Label status;
    @FXML
    Label sessionID;
    @FXML
    ImageView imageView;

    @FXML
    Button save;
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
        loadConfiguration();


        transportType.textProperty().bind(viewModel.getTransportType());
        sessionID.textProperty().bind(viewModel.getSessionId());


        // Real-time GUI updates
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

        formatToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton selectedRadioButton = (RadioButton) formatToggleGroup.getSelectedToggle();
            String selectedValue = selectedRadioButton.getText();
            viewModel.setImageFormat(selectedValue);
        });
        imageFormat.textProperty().bind(viewModel.getImageFormat());

        Image image = new Image(new FileInputStream("images/tourImage_PLACEHOLDER.png")); //2do
        imageView.setImage(image);
    }

    @FXML
    public void handleSaveButton() throws IOException {
        System.out.println("CLICKED SAVE BUTTON");
        RadioButton selectedRadioButton = (RadioButton) formatToggleGroup.getSelectedToggle();
        Configuration.setImageFormat(selectedRadioButton.getText());
        Configuration.setImageDirectory(imageDirectory.getText());
        Configuration.setImageName(imageName.getText());
        // 2do: Create tour entity at this point instead and pass as argument?
        viewModel.createNewTour();
    }


    @FXML
    private void handleUpdateImageButton() throws FileNotFoundException {
        System.out.println("updating image");
        Image image = new Image(new FileInputStream("images/tourImage_TEST.png")); //2do
        imageView.setImage(image);
    }

    @FXML
    public void handleBackButton() throws IOException {
        viewHandler.openView(Views.HOME.getFxmlFileName());
    }

    private void loadConfiguration() {
        formatToggleGroup = new ToggleGroup();
        png.setToggleGroup(formatToggleGroup);
        jpg.setToggleGroup(formatToggleGroup);
        jpeg.setToggleGroup(formatToggleGroup);
        imageName.setText(Configuration.getImageName());
        imageDirectory.setText(Configuration.getImageDirectory());
        switch (Configuration.getImageFormat()) {
            case Constants.FILE_EXTENSION_PNG -> png.setSelected(true);
            case Constants.FILE_EXTENSION_JPG -> jpg.setSelected(true);
            default -> jpeg.setSelected(true);
        }
    }
}