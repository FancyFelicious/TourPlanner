package org.fancylynx.application.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeListener;

public interface DataModel {
    DoubleProperty xProperty();

    DoubleProperty yProperty();

    DoubleProperty zProperty();

    StringProperty lastUpdateProperty();

    double[] getDataValues();

    String getLatestUpdateTimeStamp();

    void addPropertyChangeListener(PropertyChangeListener listener);
}
