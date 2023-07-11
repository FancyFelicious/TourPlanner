package org.fancylynx.application.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fancylynx.application.config.Constants;
import org.fancylynx.application.factory.ViewModelFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * Creates the views, loads the fxml files and sets the css,
 * responsible for changing the views, initializes the controllers
 */

@Component
public class ViewHandler {
    private final Stage stage;
    private final ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception {
        openView(Views.MAIN.getFxmlFileName());
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene = null;
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource(viewToOpen)); // 2do
        root = fxmlLoader.load();
        if (Views.HOME.getFxmlFileName().equals(viewToOpen)) {
            HomeController view = fxmlLoader.getController();
            view.init(viewModelFactory.getHomeViewModel(), this);
            stage.setTitle(Constants.STAGE_TITLE_HOME);
        } else if (Views.CREATETOUR.getFxmlFileName().equals(viewToOpen)) {
            TourController view = fxmlLoader.getController();
            view.init(viewModelFactory.getTourModelView(), this);
            stage.setTitle(Constants.STAGE_TITLE_CREATE_TOUR);
        } else if (Views.MAIN.getFxmlFileName().equals(viewToOpen)) {
            MainController view = fxmlLoader.getController();
            //view.init(viewModelFactory.getMainViewModel(), this);
            stage.setTitle(Constants.STAGE_TITLE_MAIN);
        }
        else {
            // 2do
            throw new IllegalArgumentException("View '" + viewToOpen + "' does not exist");
        }

        scene = new Scene(root);
        //String css = getClass().getResource("styles.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void openTourLogView(String viewToOpen) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(viewToOpen));

    }
}
