package org.fancylynx.application.view.MVVMPlayground.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataModelManager implements DataModel {
    private final Random random = new Random();
    private double x;
    private double y;
    private double z;
    private String lastUpdate;

    @Override
    public double[] getDataValues() {
        return new double[]{x, y, z};
    }

    @Override
    public String getLatestUpdateTimeStamp() {
        return lastUpdate;
    }

    public void recalculateData() {
        int first = random.nextInt(100) + 1;
        int second = random.nextInt(100) + 1;
        int bottom = Math.min(first, second);
        int top = Math.max(first, second);

        x = bottom;
        y = top - bottom;
        z = 100 - top;
        calcTimeStamp();
    }

    private void calcTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String stringDate = simpleDateFormat.format(now);
        System.out.println(stringDate);
        lastUpdate = stringDate;
    }


//    private int dataValue;
//    public DataModelManager() {
//        dataValue = 10;
//    }

//    @Override
//    public int getDataValue() {
//        return dataValue;
//    }
//
//    @Override
//    public void randomizeDataValue() {
//        dataValue = (int) (Math.random() * 100);
//    }
//
//    @Override
//    public void saveDataValue(int value) {
//        dataValue = value;
//    }
}
