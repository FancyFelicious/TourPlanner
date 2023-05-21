package org.fancylynx.application.view.MVVMPlayground.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fancylynx.application.view.MVVMPlayground.factory.ViewModelFactory;

import java.io.IOException;

public class ViewHandler {
    private final Stage stage;
    private final ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception {
        openView("ClassX");
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = null;

        fxmlLoader.setLocation(getClass().getResource(viewToOpen + "View.fxml")); // 2do
        root = fxmlLoader.load();
        if ("ClassX".equals(viewToOpen)) {
            ClassXController view = fxmlLoader.getController();
            view.init(viewModelFactory.getClassXViewModel());
            stage.setTitle("CLASS X / PIE CHART");
        }

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
