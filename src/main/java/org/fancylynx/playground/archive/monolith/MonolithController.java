package org.fancylynx.playground.archive.monolith;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.fancylynx.application.config.Configuration;
import org.fancylynx.application.config.Constants;

import java.io.IOException;

public class MonolithController {
    private Stage primaryStage;

    @FXML
    private Label imageDirectoryLabel;
    @FXML
    private TextField imageDirectory;
    @FXML
    private Label imageNameLabel;
    @FXML
    private TextField imageName;
    @FXML
    private RadioButton png;
    @FXML
    private RadioButton jpg;
    @FXML
    private RadioButton jpeg;
    @FXML
    private Label imageFormatLabel;
    @FXML
    private ToggleGroup formatToggleGroup;
    @FXML
    private Button save;
    @FXML
    private Button viewConfiguration;
    @FXML
    private Button createTour;


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void handleSaveButtonAction() {
        RadioButton selectedRadioButton = (RadioButton) formatToggleGroup.getSelectedToggle();
//        Configuration.setImageFormat(png.getText());
//        if (selectedRadioButton != null) {
        Configuration.setImageFormat(selectedRadioButton.getText());
//        }
        Configuration.setImageName(imageName.getText());
        Configuration.setImageDirectory(imageDirectory.getText());
    }


    private void handleViewConfigurationButtonAction() {
        System.out.println(Configuration.getImageDirectory());
        System.out.println(Configuration.getImageName());
        System.out.println(Configuration.getImageFormat());
    }

    private void handleCreateTourButtonAction() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TestView.fxml"));
            Parent testViewRoot = fxmlLoader.load();

            TestViewController testViewController = fxmlLoader.getController();
            testViewController.setPrimaryStage(primaryStage); // Pass the primaryStage to the TestViewController

            Scene testViewScene = new Scene(testViewRoot, 800, 600);
            primaryStage.setScene(testViewScene);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void initialize() {
        formatToggleGroup = new ToggleGroup();
        png.setToggleGroup(formatToggleGroup);
        jpg.setToggleGroup(formatToggleGroup);
        jpeg.setToggleGroup(formatToggleGroup);
        png.setSelected(true);

        imageName.setText(Constants.DEFAULT_IMAGE_NAME);
        imageDirectory.setText(Constants.DEFAULT_IMAGE_SAVE_DIRECTORY);
    }
}

// Create the UI components
//        Label directoryLabel = new Label("Default Directory:");
//        TextField directoryField = new TextField();
//        Button directoryButton = new Button("Set directory");
//
//        Label nameLabel = new Label("Default Name:");
//        TextField nameField = new TextField();
//        Button nameButton = new Button("Set name");
//
//        RadioButton pngRadioButton = new RadioButton(".png");
//        RadioButton jpgRadioButton = new RadioButton(".jpg");
//        RadioButton jpegRadioButton = new RadioButton(".jpeg");
//
//        ToggleGroup formatToggleGroup = new ToggleGroup();
//
//        // Add the radio buttons to the toggle group
//        pngRadioButton.setToggleGroup(formatToggleGroup);
//        jpgRadioButton.setToggleGroup(formatToggleGroup);
//        jpegRadioButton.setToggleGroup(formatToggleGroup);
//
//        // Set a default selection
//        pngRadioButton.setSelected(true);
//        nameField.setText("tourImage");
//        directoryField.setText("/images");
//
//        Button saveButton = new Button("Apply");
//        Button testButton = new Button("Show current config");
//
//
//        // Create an event handler for the testButton
//        EventHandler<ActionEvent> saveButtonHandler = event -> {
//            RadioButton selectedRadioButton = (RadioButton) formatToggleGroup.getSelectedToggle();
//            if (selectedRadioButton != null) {
//                Configuration.setImageFormat(pngRadioButton.getText());
//                String selectedFormat = selectedRadioButton.getText();
//                System.out.println(selectedFormat);
//            }
//            Configuration.setImageName(nameField.getText());
//            Configuration.setImageDirectory(directoryField.getText());
//        };
//
//        EventHandler<ActionEvent> showConfigHandler = event -> {
//            System.out.println(Configuration.getImageDirectory());
//            System.out.println(Configuration.getImageName());
//            System.out.println(Configuration.getImageFormat());
//        };
//
//        // Set the actions for the buttons
//        directoryButton.setOnAction(e -> setDefaultDirectory(directoryField.getText()));
//        nameButton.setOnAction(e -> setDefaultName(nameField.getText()));
//        testButton.setOnAction(showConfigHandler);
//        saveButton.setOnAction(saveButtonHandler);
//
//        // Create the layout
//        VBox root = new VBox(10);
//        root.setPadding(new Insets(15));
//        root.setAlignment(Pos.CENTER);
//        root.getChildren().addAll(
//                directoryLabel, directoryField, directoryButton,
//                nameLabel, nameField, nameButton,
//                pngRadioButton, jpgRadioButton, jpegRadioButton,
//                testButton,
//                saveButton
//        );
//
//        // Create the scene and set it to the stage
//        Scene scene = new Scene(root, 800, 600);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Edit Settings");
//        primaryStage.show();
//    }
//
