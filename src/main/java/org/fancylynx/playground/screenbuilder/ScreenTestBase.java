package org.fancylynx.playground.screenbuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ScreenTestBase extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ScreenTestDocument.fxml")));
        primaryStage.setTitle("Screen Test Base");
        primaryStage.setScene(new Scene(root, 320, 240));
        primaryStage.show();
    }
}

// public class ScreenTestBase extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(ScreenTestBase.class.getResource("ScreenTestDocument.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("title hier ok cool ich bin title");
//        stage.setScene(scene);
//        stage.show();
//    }
//}



