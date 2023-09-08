package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.fancylynx.FXMLDependencyInjection;
import org.fancylynx.application.viewmodel.MainViewModel;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Locale;

public class MainController {

    private final MainViewModel viewModel;
    @FXML
    private BorderPane mainScene;
    private ConfigurableApplicationContext applicationContext;

    public MainController(ConfigurableApplicationContext applicationContext, MainViewModel viewModel) {
        this.applicationContext = applicationContext;
        this.viewModel = viewModel;
    }

    @FXML
    public void initialize() {
    }

    @FXML
    public void importTour() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Tour File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Tour Files", "*.json"));

        var file = fileChooser.showOpenDialog(mainScene.getScene().getWindow());

        if (file != null) {
            viewModel.importTour(file);
        } else {
            System.out.println("No File selected");
        }
    }

    @FXML
    public void exportTour() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Export Tour");
        var directory = directoryChooser.showDialog(mainScene.getScene().getWindow());

        if (directory != null) {
            viewModel.exportTour(directory);
        } else {
            System.out.println("No Directory selected");
        }
    }

    @FXML
    public void createTourReport() {
        viewModel.tourReport();
    }

    @FXML
    public void createSummaryReport() {
        viewModel.summaryReport();
    }

    @FXML
    public void switchToEnglish() throws IOException {
        Parent root = FXMLDependencyInjection.load(
                "MainView.fxml",
                Locale.ENGLISH,
                applicationContext);  // Locale.GERMANY, Locale.ENGLISH
        Scene scene = new Scene(root);
        Stage stage = (Stage) mainScene.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void switchToGerman() throws IOException {
        Parent root = FXMLDependencyInjection.load(
                "MainView.fxml",
                Locale.GERMAN,
                applicationContext);  // Locale.GERMANY, Locale.ENGLISH
        Scene scene = new Scene(root);
        Stage stage = (Stage) mainScene.getScene().getWindow();
        stage.setScene(scene);
    }
}
