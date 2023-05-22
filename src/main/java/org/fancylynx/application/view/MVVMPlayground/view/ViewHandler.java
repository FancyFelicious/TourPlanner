package org.fancylynx.application.view.MVVMPlayground.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fancylynx.application.view.MVVMPlayground.factory.ViewModelFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

// 2do: make component, dependency injection
@Component
public class ViewHandler {
    private final Stage stage;
    private final ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception {
        openView(View.HOME.getFxmlFile());
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene = null;
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource(viewToOpen)); // 2do
        root = fxmlLoader.load();
        if (View.HOME.getFxmlFile().equals(viewToOpen)) {
            HomeController view = fxmlLoader.getController();
            view.init(viewModelFactory.getHomeViewModel(), this);
            stage.setTitle("CLASS X / PIE CHART");
        } else if (View.CREATETOUR.getFxmlFile().equals(viewToOpen)) {
            CreateTourController view = fxmlLoader.getController();
            view.init(viewModelFactory.getCreateTourViewModel(), this);
            stage.setTitle("CLASS Y");
        }

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
