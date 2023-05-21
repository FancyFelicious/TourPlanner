package org.fancylynx.application.view.MVVMPlayground.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

public interface DataModel {
    DoubleProperty xProperty();

    DoubleProperty yProperty();

    DoubleProperty zProperty();

    StringProperty lastUpdateProperty();

    double[] getDataValues();

    String getLatestUpdateTimeStamp();

//    int getDataValue();
//
//    void randomizeDataValue();

//    void saveDataValue(int value);
}
