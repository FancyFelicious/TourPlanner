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


//@Component
public class TourController {
    private final String testListen = "testListen";

    @FXML
    Button save;
    @FXML
    Button back;
    @FXML
    Button updateImage;
    @FXML
    Button viewConfiguration;
    @FXML
    TextField imageDirectory;
    @FXML
    TextField imageName;
    @FXML
    Label status;
    @FXML
    ToggleGroup formatToggleGroup;
    @FXML
    RadioButton png;
    @FXML
    RadioButton jpg;
    @FXML
    RadioButton jpeg;

    @FXML
    TextField TEST_INPUT;
    @FXML
    Label TEST_OUTPUT;

    @FXML
    TextField tourName;
    @FXML
    Label tourNameLabel;

    @FXML
    ImageView imageView;
    private TourViewModel viewModel;
    private ViewHandler viewHandler;

    public TourController() {

    }

    public void init(TourViewModel tourViewModel, ViewHandler viewHandler) throws FileNotFoundException {
        this.viewModel = tourViewModel;
        this.viewHandler = viewHandler;
        loadConfiguration();

        TEST_INPUT.textProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setTEST_OUTPUT(newValue); // Update the TEST_OUTPUT property in the view model
        });
        TEST_OUTPUT.textProperty().bind(viewModel.TEST_OUTPUTProperty()); // Bind the TEST_OUTPUT label to the view model property

//        TEST_OUTPUT.textProperty().addListener((observable, oldValue, newValue) -> {
//            viewModel.setTEST_OUTPUT(newValue); // Update the TEST_OUTPUT property in the view model
//        });

//        tourNameLabel.textProperty().bind(viewModel.testTourNameProperty()); // Bind the TEST_OUTPUT label to the view model property

//        TEST_INPUT.textProperty().bindBidirectional(viewModel.TEST_OUTPUTProperty());
//
//        ObservableList<String> testUpdate = FXCollections.observableArrayList(testListen);
////        TEST_OUTPUT.setText(TEST_INPUT.getText());
//        tourNameLabel.setText(testUpdate.toString());


        Image image = new Image(new FileInputStream("images/tourImage_TEST.png")); //2do
        imageView.setImage(image);
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

    @FXML
    public void handleBackButton() throws IOException {
        viewHandler.openView(Views.HOME.getFxmlFileName());
    }

    @FXML
    public void handleSaveButton() throws IOException {
        System.out.println("saving");
        RadioButton selectedRadioButton = (RadioButton) formatToggleGroup.getSelectedToggle();
        Configuration.setImageFormat(selectedRadioButton.getText());
        Configuration.setImageName(imageName.getText());
        Configuration.setImageDirectory(imageDirectory.getText());

        Configuration.setTourName(tourName.getText());
        // Create tour entity at this point instead and pass as argument?

        viewModel.createNewTour();

//        viewModel.createNewTour();
    }

    @FXML
    private void handleViewConfigurationButton() {
        System.out.println(Configuration.getImageDirectory());
        System.out.println(Configuration.getImageName());
        System.out.println(Configuration.getImageFormat());
    }

    @FXML
    private void handleUpdateImageButton() throws FileNotFoundException {
        System.out.println("updating image");
        Image image = new Image(new FileInputStream("images/tourImage_3.png"));
        imageView.setImage(image);
    }
}