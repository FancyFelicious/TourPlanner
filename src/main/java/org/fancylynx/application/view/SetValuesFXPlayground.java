package org.fancylynx.application.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.fancylynx.application.config.Configuration;
import org.fancylynx.application.service.SaveImageToFileSystem;

public class SetValuesFXPlayground extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the UI components
        Label directoryLabel = new Label("Default Directory:");
        TextField directoryField = new TextField();
        Button directoryButton = new Button("Set directory");

        Label nameLabel = new Label("Default Name:");
        TextField nameField = new TextField();
        Button nameButton = new Button("Set name");

        RadioButton pngRadioButton = new RadioButton(".png");
        RadioButton jpgRadioButton = new RadioButton(".jpg");
        RadioButton jpegRadioButton = new RadioButton(".jpeg");

        ToggleGroup formatToggleGroup = new ToggleGroup();

        // Add the radio buttons to the toggle group
        pngRadioButton.setToggleGroup(formatToggleGroup);
        jpgRadioButton.setToggleGroup(formatToggleGroup);
        jpegRadioButton.setToggleGroup(formatToggleGroup);

        // Set a default selection
        pngRadioButton.setSelected(true);
        nameField.setText("tourImage");
        directoryField.setText("/images");

        Button saveButton = new Button("Apply");
        Button testButton = new Button("Show current config");


        // Create an event handler for the testButton
        EventHandler<ActionEvent> saveButtonHandler = event -> {
            RadioButton selectedRadioButton = (RadioButton) formatToggleGroup.getSelectedToggle();
            if (selectedRadioButton != null) {
                Configuration.setImageFormat(pngRadioButton.getText());
                String selectedFormat = selectedRadioButton.getText();
                System.out.println(selectedFormat);
            }
            Configuration.setImageName(nameField.getText());
            Configuration.setImageDirectory(directoryField.getText());
        };

        EventHandler<ActionEvent> showConfigHandler = event -> {
            System.out.println(Configuration.getImageDirectory());
            System.out.println(Configuration.getImageName());
            System.out.println(Configuration.getImageFormat());
        };

        // Set the actions for the buttons
        directoryButton.setOnAction(e -> setDefaultDirectory(directoryField.getText()));
        nameButton.setOnAction(e -> setDefaultName(nameField.getText()));
        testButton.setOnAction(showConfigHandler);
        saveButton.setOnAction(saveButtonHandler);

        // Create the layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(
                directoryLabel, directoryField, directoryButton,
                nameLabel, nameField, nameButton,
                pngRadioButton, jpgRadioButton, jpegRadioButton,
                testButton,
                saveButton
        );

        // Create the scene and set it to the stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Edit Settings");
        primaryStage.show();
    }

    private void setDefaultDirectory(String directory) {
        // Set the default directory
        SaveImageToFileSystem.setDefaultDirectory(directory);
        System.out.println("Directory set: " + directory); // 2do

    }

    private void setDefaultName(String name) {
        // Set the default name
        SaveImageToFileSystem.setDefaultName(name);
        System.out.println("Nam set: " + name); // 2do

    }

    private void setDefaultFormat(String format) {
        // Set the default format
        SaveImageToFileSystem.setDefaultFormat(format);
        System.out.println("Format set: " + format); // 2do

    }

    private void youClickedMe() {
        // Handle the OK button click
        System.out.println("OK button clicked!");
    }
}
