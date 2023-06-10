package org.fancylynx.application.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Configuration {
    // 2do: probably delete forever
//    public static String imageDirectory = Constants.DEFAULT_IMAGE_SAVE_DIRECTORY;
//    public static String imageName = Constants.DEFAULT_IMAGE_NAME;
//    public static String imageFormat = Constants.DEFAULT_IMAGE_FORMAT;

    private Configuration() {
    }

    // 2do: rename to 'load'?
    // Set JVM environment variables - pulled from .env file
    public static void loadAppConfiguration() {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }
}
