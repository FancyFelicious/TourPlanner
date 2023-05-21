package org.fancylynx.application.view.MVVMPlayground.viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.fancylynx.application.view.MVVMPlayground.model.DataModel;

public class ClassXViewModel {
    private final DoubleProperty x;
    private final DoubleProperty y;
    private final DoubleProperty z;
    private final StringProperty updateTimeStamp;

    private final DataModel model;

    public ClassXViewModel(DataModel model) {
        this.model = model;
        x = new SimpleDoubleProperty();
        y = new SimpleDoubleProperty();
        z = new SimpleDoubleProperty();
        updateTimeStamp = new SimpleStringProperty("Last update: ");
    }

    public void updatePieChart() {
        double[] dataValues = model.getDataValues();
        x.setValue(dataValues[0]);
        y.setValue(dataValues[1]);
        z.setValue(dataValues[2]);
        updateTimeStamp.setValue("Last update: " + model.getLatestUpdateTimeStamp());

    }

    public DoubleProperty xProperty() {
        return x;
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public DoubleProperty zProperty() {
        return z;
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

}
