package org.fancylynx.playground.screenbuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ScreenTestBaseController {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button linksButton;

    @FXML
    private Button rechtsButton;

    @FXML
    private Button button;

    // You can add methods and event handlers here

    // Example event handler for the linksButton
    @FXML
    private void handleLinksButtonAction() {
        // Add your logic here
    }

    // Example event handler for the rechtsButton
    @FXML
    private void handleRechtsButtonAction() {
        // Add your logic here
    }

    // Example event handler for the button
    @FXML
    private void handleButtonAction() {
        // Add your logic here
    }
}
