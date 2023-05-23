package org.fancylynx.playground.monolith;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Monolith extends Application {
//    SceneController sceneController = new SceneController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Monolith.fxml"));
        Parent root = fxmlLoader.load();

        MonolithController monolithController = fxmlLoader.getController();
        monolithController.setPrimaryStage(primaryStage);


        primaryStage.setTitle("M O N O L I T H");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
