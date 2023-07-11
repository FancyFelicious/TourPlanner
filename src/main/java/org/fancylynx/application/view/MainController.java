package org.fancylynx.application.view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.viewmodel.MainViewModel;

import java.io.IOException;

public class MainController {

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab contentTab;
    @FXML
    private ListView<Tour> tourList;
    @FXML
    private TourLogController tourLogController;
    //private ViewHandler viewHandler;
    private final MainViewModel viewModel;

    public MainController(MainViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void init() throws IOException {
        //this.viewHandler = viewHandler;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TourDetails.fxml"));
        AnchorPane content = loader.load();
        contentTab.setContent(content);

        AnchorPane detailsAnchor = (AnchorPane) content.lookup("#detailsAnchor");
        detailsAnchor.prefWidthProperty().bind(tabPane.widthProperty());
        detailsAnchor.prefHeightProperty().bind(tabPane.heightProperty());

        tourList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.selectTour(new SimpleObjectProperty<>(newValue));
        });
    }

   /* public void handleCreateTourButton() throws IOException {
        viewHandler.openView(Views.CREATETOUR.getFxmlFileName());
    }*/

}
