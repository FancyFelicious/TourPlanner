package org.fancylynx;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fancylynx.application.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Locale;

@SpringBootApplication
public class TourPlanner extends Application {
    public static void main(String[] args) {
        Configuration.loadAppConfiguration();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TourPlanner.class);
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

        Parent root = FXMLDependencyInjection.load(
                "MainView.fxml",
                Locale.GERMAN,
                applicationContext);  // Locale.GERMANY, Locale.ENGLISH

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1000);
        stage.setMinHeight(600);
        stage.show();
    }

}

