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
    Label imageDirectoryOutput;

    @FXML
    TextField imageNameInput;
    @FXML
    Label imageNameOutput;

    @FXML
    TextField originInput;
    @FXML
    Label originOutput;

    @FXML
    TextField destinationInput;
    @FXML
    Label destinationOutput;

    @FXML
    TextField nameInput;
    @FXML
    Label nameOutput;

    @FXML
    TextField descriptionInput;
    @FXML
    Label descriptionOutput;

    @FXML
    ToggleGroup formatToggleGroup;
    @FXML
    RadioButton png;
    @FXML
    RadioButton jpg;
    @FXML
    RadioButton jpeg;
    @FXML
    Label imageFormatOutput;

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
    @FXML
    Button viewConfiguration;

    private TourViewModel viewModel;
    private ViewHandler viewHandler;

    public TourController() {
    }

    // Note: Init method needed because constructor of controller must be empty
    public void init(TourViewModel tourViewModel, ViewHandler viewHandler) throws FileNotFoundException {
        this.viewModel = tourViewModel;
        this.viewHandler = viewHandler;
        loadConfiguration();

        // Real-time GUI updates
        nameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setNameOutput(newValue);
        });
        nameOutput.textProperty().bind(viewModel.getNameOutput());

        descriptionInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setDescriptionOutput(newValue);
        });
        descriptionOutput.textProperty().bind(viewModel.getDescriptionOutput());

        originInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setOriginOutput(newValue);
        });
        originOutput.textProperty().bind(viewModel.getOriginOutput());

        destinationInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setDestinationOutput(newValue);
        });
        destinationOutput.textProperty().bind(viewModel.getDestinationOutput());

        imageDirectoryInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setImageDirectoryOutput(newValue);
        });
        imageDirectoryOutput.textProperty().bind(viewModel.getImageDirectoryOutput());

        imageNameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setImageNameOutput(newValue);
        });
        imageNameOutput.textProperty().bind(viewModel.getImageNameOutput());


        Image image = new Image(new FileInputStream("images/tourImage_TEST.png")); //2do
        imageView.setImage(image);


//        TEST_INPUT.textProperty().addListener((observable, oldValue, newValue) -> {
//            viewModel.setTEST_OUTPUT(newValue); // Update the TEST_OUTPUT property in the view model
//        });
//        TEST_OUTPUT.textProperty().bind(viewModel.TEST_OUTPUTProperty()); // Bind the TEST_OUTPUT label to the view model property
    }


    @FXML
    public void handleBackButton() throws IOException {
        viewHandler.openView(Views.HOME.getFxmlFileName());
    }

    @FXML
    public void handleSaveButton() throws IOException {
        System.out.println("CLICKED SAVE BUTTON");
        RadioButton selectedRadioButton = (RadioButton) formatToggleGroup.getSelectedToggle();
        Configuration.setImageFormat(selectedRadioButton.getText());
        Configuration.setImageDirectory(imageDirectoryOutput.getText());
        Configuration.setImageName(imageNameOutput.getText());
//      Configuration.setTourName(tourNameOutput.getText());

        // 2do: Create tour entity at this point instead and pass as argument?
        viewModel.createNewTour();
    }

    @FXML
    private void handleUpdateImageButton() throws FileNotFoundException {
        System.out.println("updating image");
        Image image = new Image(new FileInputStream("images/tourImage_3.png"));
        imageView.setImage(image);
    }

    @FXML
    private void handleViewConfigurationButton() {
        System.out.println(Configuration.getImageDirectory());
        System.out.println(Configuration.getImageName());
        System.out.println(Configuration.getImageFormat());
    }

    private void loadConfiguration() {
        formatToggleGroup = new ToggleGroup();
        png.setToggleGroup(formatToggleGroup);
        jpg.setToggleGroup(formatToggleGroup);
        jpeg.setToggleGroup(formatToggleGroup);
        imageNameInput.setText(Configuration.getImageName());
        imageDirectoryOutput.setText(Configuration.getImageDirectory());
        switch (Configuration.getImageFormat()) {
            case Constants.FILE_EXTENSION_PNG -> png.setSelected(true);
            case Constants.FILE_EXTENSION_JPG -> jpg.setSelected(true);
            default -> jpeg.setSelected(true);
        }
    }
}