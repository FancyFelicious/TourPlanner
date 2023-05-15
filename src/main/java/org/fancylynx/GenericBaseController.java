package org.fancylynx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GenericBaseController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("versace versace versace");
    }
}