package org.fancylynx.application.config;

import io.github.cdimascio.dotenv.Dotenv;

// 2do: different approach to load environment variables? (spring style) - see https://www.baeldung.com/spring-properties-file-outside-jar
//@org.springframework.context.annotation.Configuration
//@PropertySource("classpath:application.yaml")

public class Configuration {

    private static String imageDirectory = Constants.DEFAULT_IMAGE_SAVE_DIRECTORY;
    private static String imageName = Constants.DEFAULT_IMAGE_NAME;
    private static String imageFormat = Constants.DEFAULT_IMAGE_FORMAT;

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

    public static void loadAppConfiguration() {
        // Set JVM environment variables - pulled from .env
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }
}
