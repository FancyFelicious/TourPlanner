package org.fancylynx.application.view.MVVMPlayground.model;

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
        recalculateData();
    }

    @Override
    public double[] getDataValues() {
        return new double[]{x.get(), y.get(), z.get()};
    }

    @Override
    public String getLatestUpdateTimeStamp() {
        return lastUpdate.get();
    }

    @Override
    public DoubleProperty xProperty() {
        return x;
    }

    @Override
    public DoubleProperty yProperty() {
        return y;
    }

    @Override
    public DoubleProperty zProperty() {
        return z;
    }

    @Override
    public StringProperty lastUpdateProperty() {
        return lastUpdate;
    }

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
        calcTimeStamp();

        propertyChangeSupport.firePropertyChange("dataValues", null, getDataValues());
//        propertyChangeSupport.firePropertyChange("latestUpdateTimeStamp", null, getLatestUpdateTimeStamp());

    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private void calcTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String stringDate = simpleDateFormat.format(now);
        System.out.println(stringDate);
        lastUpdate.set(stringDate);
    }
}


//package org.fancylynx.application.view.MVVMPlayground.model;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Random;
//
//public class DataModelManager implements DataModel {
//    private final Random random = new Random();
//    private double x;
//    private double y;
//    private double z;
//    private String lastUpdate;
//
//    @Override
//    public double[] getDataValues() {
//        return new double[]{x, y, z};
//    }
//
//    @Override
//    public String getLatestUpdateTimeStamp() {
//        return lastUpdate;
//    }
//
//    public void recalculateData() {
//        final int MAX_VALUE = 100;
//        final int MIN_VALUE = 1;
//        int randomNumber1 = random.nextInt(MAX_VALUE) + MIN_VALUE;
//        int randomNumber2 = random.nextInt(MAX_VALUE) + MIN_VALUE;
//        int minValue = Math.min(randomNumber1, randomNumber2);
//        int maxValue = Math.max(randomNumber1, randomNumber2);
//        x = minValue;
//        y = maxValue - minValue;
//        z = MAX_VALUE - maxValue;
//        calcTimeStamp();
//    }
//
//    private void calcTimeStamp() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//        Date now = new Date();
//        String stringDate = simpleDateFormat.format(now);
//        System.out.println(stringDate);
//        lastUpdate = stringDate;
//    }
//}
