package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import lombok.Getter;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.viewmodel.TourLogOverviewViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class TourLogOverviewController implements Initializable {
    @FXML
    public ListView<TourLogModel> tourLogList;


    @Getter
    private final TourLogOverviewViewModel tourLogOverviewViewModel;

    public TourLogOverviewController(TourLogOverviewViewModel tourLogOverviewViewModel) {
        this.tourLogOverviewViewModel = tourLogOverviewViewModel;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tourLogList.setItems(tourLogOverviewViewModel.getObservableTourLogs());
        tourLogList.getSelectionModel().selectedItemProperty().addListener(tourLogOverviewViewModel.getChangeListener());
    }

    public void handleCreateTourLog() {
        tourLogOverviewViewModel.addTourLog();
        tourLogList.getSelectionModel().selectLast();
    }

    public void deleteTourLog() {
        tourLogOverviewViewModel.deleteTourLog(tourLogList.getSelectionModel().getSelectedItem());
    }
}
