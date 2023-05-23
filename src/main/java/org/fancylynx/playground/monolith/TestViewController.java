package org.fancylynx.playground.monolith;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TestViewController {
    @FXML
    private Button backButton;

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void handleBackButtonAction() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Monolith.fxml"));
            Parent monolithViewRoot = fxmlLoader.load();

            MonolithController monolithController = fxmlLoader.getController();
            monolithController.setPrimaryStage(primaryStage); // Pass the primaryStage back to the MonolithController

            Scene monolithViewScene = new Scene(monolithViewRoot, 800, 600);
            primaryStage.setScene(monolithViewScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
