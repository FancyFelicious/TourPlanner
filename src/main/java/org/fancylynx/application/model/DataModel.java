package org.fancylynx.application.model;

import java.beans.PropertyChangeListener;

public interface DataModel {
    void recalculateData();

    double[] getDataValues();

    String getTimeStamp();

    void addPropertyChangeListener(PropertyChangeListener listener);
}

//    DoubleProperty xProperty();
//
//    DoubleProperty yProperty();
//
//    DoubleProperty zProperty();
//
//    StringProperty lastUpdateProperty();
