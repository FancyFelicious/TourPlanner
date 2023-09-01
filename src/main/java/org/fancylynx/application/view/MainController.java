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
    private Tab contentTab;
    @FXML
    private ListView<Tour> tourList;
    @FXML
    private TourLogOverviewController tourLogController;
    //private ViewHandler viewHandler;
    private final MainViewModel viewModel;

    public MainController(MainViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    public void initialize() throws IOException {
        //this.viewHandler = viewHandler;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TourDetails.fxml"));
        AnchorPane content = loader.load();
        contentTab.setContent(content);

        AnchorPane detailsAnchor = (AnchorPane) content.lookup("#detailsAnchor");
        detailsAnchor.prefWidthProperty().bind(tabPane.widthProperty());
        detailsAnchor.prefHeightProperty().bind(tabPane.heightProperty());

        //tourList.setItems();
        tourList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.selectTour(new SimpleObjectProperty<>(newValue));
        });
    }

    public void handleAddNewTour() {
        try {
            FXMLLoader loader = FXMLDependencyInjection.getLoader("TourView.fxml", Locale.GERMAN, null);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setTitle("Add Tour");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public void handleCreateTourButton() throws IOException {
        viewHandler.openView(Views.CREATETOUR.getFxmlFileName());
    }*/

}
