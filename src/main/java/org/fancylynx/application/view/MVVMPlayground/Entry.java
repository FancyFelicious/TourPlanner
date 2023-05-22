package org.fancylynx.application.view.MVVMPlayground;

import javafx.application.Application;
import javafx.stage.Stage;
import org.fancylynx.application.view.MVVMPlayground.factory.ModelFactory;
import org.fancylynx.application.view.MVVMPlayground.factory.ViewModelFactory;
import org.fancylynx.application.view.MVVMPlayground.model.DataModelManager;
import org.fancylynx.application.view.MVVMPlayground.view.ViewHandler;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Entry extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // 2do: injection?
        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();

        runAutoUpdate((DataModelManager) modelFactory.getDataModel());
    }

    // 2do: remove later - testing / simulating changes to db
    private void runAutoUpdate(DataModelManager m) {
        AutoUpdater autoUpdater = new AutoUpdater(m);
        Thread thread = new Thread(autoUpdater);
        thread.setDaemon(true);
        thread.start();
    }
}
