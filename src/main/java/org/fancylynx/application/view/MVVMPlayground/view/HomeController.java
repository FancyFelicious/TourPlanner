package org.fancylynx.application.view.MVVMPlayground.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.fancylynx.application.view.MVVMPlayground.viewmodel.HomeViewModel;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HomeController {
    private final PieChart.Data x = new PieChart.Data("X", 0);
    private final PieChart.Data y = new PieChart.Data("Y", 0);
    private final PieChart.Data z = new PieChart.Data("Z", 0);
    @FXML
    Label dataLabel;
    @FXML
    Button createTour;
    @FXML
    PieChart pieChart;


    private HomeViewModel viewModel;
    private ViewHandler viewHandler;

    public HomeController() {
    }

    public void init(HomeViewModel viewModel, ViewHandler viewHandler) {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;

//        this.viewHandler = viewHandler;
        x.pieValueProperty().bind(viewModel.xProperty());
        y.pieValueProperty().bind(viewModel.yProperty());
        z.pieValueProperty().bind(viewModel.zProperty());

        dataLabel.textProperty().bind(viewModel.updateTimeStampProperty());

        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(x, y, z);
        pieChart.setData(data);
    }

    public void onCreateTourButton() throws IOException {
        viewHandler.openView(View.CREATETOUR.getFxmlFile());
    }
}
