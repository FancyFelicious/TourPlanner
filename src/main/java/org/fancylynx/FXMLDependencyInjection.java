package org.fancylynx;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import org.fancylynx.application.factory.ControllerFactory;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class FXMLDependencyInjection {
    public static Parent load(String location,
                              Locale locale,
                              ConfigurableApplicationContext context) throws IOException {
        FXMLLoader loader = getLoader(location, locale, context);
        return loader.load();
    }

    public static FXMLLoader getLoader(String location,
                                       Locale locale,
                                       ConfigurableApplicationContext context) {
        return new FXMLLoader(
                FXMLDependencyInjection.class.getResource("/org/fancylynx/application/view/" + location),
                ResourceBundle.getBundle("org.fancylynx.application.view." + "gui_strings", locale),
                new JavaFXBuilderFactory(),
                controllerClass-> ControllerFactory.getInstance(context).create(controllerClass)
        );
    }
}
