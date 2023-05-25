package org.fancylynx.application.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.fancylynx.application.viewmodel.HomeViewModel;

import java.io.IOException;

//@Component
public class HomeController {
    private final PieChart.Data x = new PieChart.Data("X", 40);
    private final PieChart.Data y = new PieChart.Data("Y", 30);
    private final PieChart.Data z = new PieChart.Data("Z", 20);

    @FXML
    Label dataLabel;
    @FXML
    Button createTour;
    @FXML
    PieChart pieChart;

    // 2do: testing
    @FXML
    Button forceUpdate;


    private ViewHandler viewHandler;
    private HomeViewModel viewModel;

    public HomeController() {
    }

    public void init(HomeViewModel viewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;

        x.pieValueProperty().bind(viewModel.xProperty());
        y.pieValueProperty().bind(viewModel.yProperty());
        z.pieValueProperty().bind(viewModel.zProperty());
        dataLabel.textProperty().bind(viewModel.timeStampProperty());

        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(x, y, z);
        pieChart.setData(data);
    }

    public void handleCreateTourButton() throws IOException {
        viewHandler.openView(Views.CREATETOUR.getFxmlFileName());
    }

    public void handleForceUpdateButton() {
        System.out.println("Force update button pressed");
        viewModel.forceUpdate();
    }
}
