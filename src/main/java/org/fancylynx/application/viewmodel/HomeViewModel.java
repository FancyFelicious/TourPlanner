package org.fancylynx.application.viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.fancylynx.application.model.DataModel;
import org.springframework.stereotype.Component;

// 2do: make component, dependency injection
@Component
public class HomeViewModel {
    private final DoubleProperty x;
    private final DoubleProperty y;
    private final DoubleProperty z;
    private final StringProperty updateTimeStamp;

    private final DataModel model;

    public HomeViewModel(DataModel model) {
        this.model = model;
        x = new SimpleDoubleProperty();
        y = new SimpleDoubleProperty();
        z = new SimpleDoubleProperty();
        updateTimeStamp = new SimpleStringProperty("Last update: ");

        // Bind the properties to the model
//        x.bind(model.xProperty());
//        y.bind(model.yProperty());
//        z.bind(model.zProperty());
//        updateTimeStamp.bind(model.updateTimeStampProperty());

        model.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("dataValues")) {
                double[] dataValues = (double[]) evt.getNewValue();
                x.setValue(dataValues[0]);
                y.setValue(dataValues[1]);
                z.setValue(dataValues[2]);
            } else if (evt.getPropertyName().equals("latestUpdateTimeStamp")) {
                String timeStamp = (String) evt.getNewValue();
                updateTimeStamp.setValue("Last update: " + timeStamp);
            }
        });
    }

//    public void updatePieChart() {
//        double[] dataValues = model.getDataValues();
//        x.setValue(dataValues[0]);
//        y.setValue(dataValues[1]);
//        z.setValue(dataValues[2]);
//        updateTimeStamp.setValue("Last update: " + model.getLatestUpdateTimeStamp());
//    }

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
