package org.fancylynx.application.view.monolith;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.fancylynx.application.config.Configuration;

public class MonolithController {
    @FXML
    private TextField imageDirectory;
    @FXML
    private TextField imageName;


    // 2do: add image formats
    @FXML
    private RadioButton png;
    @FXML
    private RadioButton jpg;
    @FXML
    private RadioButton jpeg;
    @FXML
    private ToggleGroup formatToggleGroup;

    @FXML
    private Button save;
    @FXML
    private Button viewConfiguration;
    @FXML
    private Button createTour;
    @FXML
    private Button testButton;


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


    @FXML
    private void handleViewConfigurationButtonAction() {
        System.out.println(Configuration.getImageDirectory());
        System.out.println(Configuration.getImageName());
        System.out.println(Configuration.getImageFormat());
    }

    @FXML
    private void handleCreateTourButtonAction() {
        // Add your logic here
    }

    @FXML
    private void handleTestButtonAction() {

    }

    public void initialize() {
        formatToggleGroup = new ToggleGroup();
        png.setToggleGroup(formatToggleGroup);
        jpg.setToggleGroup(formatToggleGroup);
        jpeg.setToggleGroup(formatToggleGroup);
        png.setSelected(true);

        imageName.setText("tourImage");
        imageDirectory.setText("/images");
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
//    private void setDefaultDirectory(String directory) {
//        // Set the default directory
//        SaveImageToFileSystem.setDefaultDirectory(directory);
//        System.out.println("Directory set: " + directory); // 2do
//
//    }
//
//    private void setDefaultName(String name) {
//        // Set the default name
//        SaveImageToFileSystem.setDefaultName(name);
//        System.out.println("Nam set: " + name); // 2do
//
//    }
//
//    private void setDefaultFormat(String format) {
//        // Set the default format
//        SaveImageToFileSystem.setDefaultFormat(format);
//        System.out.println("Format set: " + format); // 2do
//
//    }
//
//    private void youClickedMe() {
//        // Handle the OK button click
//        System.out.println("OK button clicked!");
//    }