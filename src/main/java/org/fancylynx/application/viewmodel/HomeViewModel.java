package org.fancylynx.application.viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.fancylynx.application.model.DataModel;
import org.springframework.stereotype.Component;

@Component
public class HomeViewModel {
    private final DoubleProperty x;
    private final DoubleProperty y;
    private final DoubleProperty z;
    private final StringProperty timeStamp;
    private final DataModel model;

    public HomeViewModel(DataModel model) {
        this.model = model;
        x = new SimpleDoubleProperty();
        y = new SimpleDoubleProperty();
        z = new SimpleDoubleProperty();
        timeStamp = new SimpleStringProperty("Last Update: ");

        model.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("dataValues")) {
                double[] dataValues = (double[]) evt.getNewValue();
                x.setValue(dataValues[0]);
                y.setValue(dataValues[1]);
                z.setValue(dataValues[2]);
            } else if (evt.getPropertyName().equals("timeStamp")) {
                String lastUpdate = "Last Update: " + evt.getNewValue();
                this.timeStamp.setValue(lastUpdate);
            }
        });
    }

    public void forceUpdate() {
        model.recalculateData();
//        model.recalculateTimeStamp();
//        updateTestString("FORCE UPDATE: " + model.getLatestUpdateTimeStamp());
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

    public StringProperty timeStampProperty() {
        return timeStamp;
    }

    public void updateTestString(String newString) {
        timeStamp.set(newString);
    }
}

//        double[] dataValues = model.getDataValues();
//        x.setValue(dataValues[0]);
//        y.setValue(dataValues[1]);
//        z.setValue(dataValues[2]);
//        timeStamp.set("Last updatevxdvx: " + model.getLatestUpdateTimeStamp());
