package org.fancylynx.application.BL.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.stereotype.Repository;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Repository
public class DataModelManager implements DataModel {
    private final Random random = new Random();
    private final DoubleProperty x = new SimpleDoubleProperty();
    private final DoubleProperty y = new SimpleDoubleProperty();
    private final DoubleProperty z = new SimpleDoubleProperty();
    private final StringProperty lastUpdate = new SimpleStringProperty();
    private final PropertyChangeSupport propertyChangeSupport;

    public DataModelManager() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    // Fake db changes
    public void recalculateData() {
        final int MAX_VALUE = 100;
        final int MIN_VALUE = 1;
        int randomNumber1 = random.nextInt(MAX_VALUE) + MIN_VALUE;
        int randomNumber2 = random.nextInt(MAX_VALUE) + MIN_VALUE;
        int minValue = Math.min(randomNumber1, randomNumber2);
        int maxValue = Math.max(randomNumber1, randomNumber2);
        x.set(minValue);
        y.set(maxValue - minValue);
        z.set(MAX_VALUE - maxValue);
        propertyChangeSupport.firePropertyChange("dataValues", null, getDataValues());
        recalculateTimeStamp();
    }

    private void recalculateTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String timeStamp = simpleDateFormat.format(now);
        lastUpdate.set(timeStamp);
        propertyChangeSupport.firePropertyChange("timeStamp", null, getTimeStamp());
    }

    @Override
    public double[] getDataValues() {
        return new double[]{x.get(), y.get(), z.get()};
    }

    @Override
    public String getTimeStamp() {
        return lastUpdate.get();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    // 2do: delete?
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}