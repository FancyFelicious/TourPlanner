package org.fancylynx.application.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Configuration {
    private static String imageDirectory = Constants.DEFAULT_IMAGE_SAVE_DIRECTORY;
    private static String imageName = Constants.DEFAULT_IMAGE_NAME;
    private static String imageFormat = Constants.DEFAULT_IMAGE_FORMAT;

    // 2do: remove?
    private Configuration() {
    }

    public static String getImageDirectory() {
        return imageDirectory;
    }

    public static void setImageDirectory(String imageDirectory) {
        Configuration.imageDirectory = imageDirectory;
    }

    public static String getImageName() {
        return imageName;
    }

    public static void setImageName(String imageName) {
        Configuration.imageName = imageName;
    }

    public static String getImageFormat() {
        return imageFormat;
    }

    public static void setImageFormat(String imageFormat) {
        Configuration.imageFormat = imageFormat;
    }

    // Set JVM environment variables - pulled from .env file
    public static void loadAppConfiguration() {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }
}
