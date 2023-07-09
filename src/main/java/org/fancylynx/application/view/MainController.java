package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import org.fancylynx.application.viewmodel.HomeViewModel;
import org.fancylynx.application.viewmodel.MainViewModel;

import java.io.IOException;

public class MainController {

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab contentTab;
    private ViewHandler viewHandler;
    private MainViewModel viewModel;

    public void init(MainViewModel mainViewModel, ViewHandler viewHandler) throws IOException {
        this.viewModel = mainViewModel;
        this.viewHandler = viewHandler;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TourDetails.fxml"));
        AnchorPane content = loader.load();
        contentTab.setContent(content);

        AnchorPane detailsAnchor = (AnchorPane) content.lookup("#detailsAnchor");
        detailsAnchor.prefWidthProperty().bind(tabPane.widthProperty());
        detailsAnchor.prefHeightProperty().bind(tabPane.heightProperty());
    }

    public void handleCreateTourButton() throws IOException {
        viewHandler.openView(Views.CREATETOUR.getFxmlFileName());
    }

}
