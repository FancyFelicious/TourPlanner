package org.fancylynx.application.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.fancylynx.application.viewmodel.SearchBarViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchBarController implements Initializable {
    @FXML
    private TextField searchField;

    private final SearchBarViewModel searchBarViewModel;

    public SearchBarController(SearchBarViewModel searchBarViewModel) {
        this.searchBarViewModel = searchBarViewModel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        searchField.setOnKeyPressed( event -> {
            if( event.getCode() == KeyCode.ENTER ) {
                System.out.println("Enter pressed");
            }
        });
    }

}
