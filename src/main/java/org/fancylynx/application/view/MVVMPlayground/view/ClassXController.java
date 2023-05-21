package org.fancylynx.application.view.MVVMPlayground.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.fancylynx.application.view.MVVMPlayground.viewmodel.ClassXViewModel;

public class ClassXController {
    private final PieChart.Data x = new PieChart.Data("X", 0);
    private final PieChart.Data y = new PieChart.Data("Y", 0);
    private final PieChart.Data z = new PieChart.Data("Z", 0);
    @FXML
    Label dataLabel;
    @FXML
    Button updateButton;
    @FXML
    PieChart pieChart;

    private ClassXViewModel viewModel;

    public ClassXController() {
    }

    public void init(ClassXViewModel classXViewModel) {
        this.viewModel = classXViewModel;
        x.pieValueProperty().bind(viewModel.xProperty());
        y.pieValueProperty().bind(viewModel.yProperty());
        z.pieValueProperty().bind(viewModel.zProperty());

        dataLabel.textProperty().bind(viewModel.updateTimeStampProperty());

        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(x, y, z);
        pieChart.setData(data);
    }

//    public void onUpdateButton() {
//        viewModel.updatePieChart();
//    }
}
