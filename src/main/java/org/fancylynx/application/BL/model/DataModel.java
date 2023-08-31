package org.fancylynx.application.BL.model;

import java.beans.PropertyChangeListener;

public interface DataModel {
    void recalculateData();

    double[] getDataValues();

    String getTimeStamp();

    void addPropertyChangeListener(PropertyChangeListener listener);
}
