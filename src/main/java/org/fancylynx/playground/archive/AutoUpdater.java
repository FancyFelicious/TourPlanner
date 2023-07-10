package org.fancylynx.playground.archive;

import org.fancylynx.application.model.DataModelManager;

import java.util.Random;

public class AutoUpdater implements Runnable {
    private final DataModelManager dataModelManager;

    public AutoUpdater(DataModelManager dataModelManager) {
        this.dataModelManager = dataModelManager;
    }

    // Updates db every few seconds for testing purposes (pie chart)
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            dataModelManager.recalculateData();
            try {
                Thread.sleep(random.nextInt(5000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
