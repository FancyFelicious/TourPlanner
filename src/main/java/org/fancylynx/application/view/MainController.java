package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.fancylynx.application.viewmodel.MainViewModel;

import java.io.IOException;

public class MainController {

    @FXML
    private BorderPane mainScene;
    private final MainViewModel viewModel;

    public MainController(MainViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    public void initialize() throws IOException {
    }

    @FXML
    public void importTour(){
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
}
