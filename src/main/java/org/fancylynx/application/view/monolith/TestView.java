package org.fancylynx.application.view.monolith;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TestView extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TestView.fxml"));
        Parent root = fxmlLoader.load();

        TestViewController testViewController = fxmlLoader.getController();
        testViewController.setPrimaryStage(primaryStage);

        primaryStage.setTitle("TESTVIEW");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


}
