package org.fancylynx.application.view;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.fancylynx.FXMLDependencyInjection;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.viewmodel.MainViewModel;

import java.io.IOException;
import java.util.Locale;

public class MainController {

    @FXML
    private TabPane tabPane;
    @FXML
    private TourLogOverviewController tourLogController;
    //private ViewHandler viewHandler;
    private final MainViewModel viewModel;

    public MainController(MainViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    public void initialize() throws IOException {
    }

}
