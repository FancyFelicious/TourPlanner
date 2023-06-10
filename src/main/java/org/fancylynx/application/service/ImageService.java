package org.fancylynx.application.service;

import org.fancylynx.application.config.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// 2do: annotation?
public class ImageService {
    public static String imageDirectory = Constants.DEFAULT_IMAGE_SAVE_DIRECTORY;
    public static String imageName = Constants.DEFAULT_IMAGE_NAME;
    public static String imageFormat = Constants.DEFAULT_IMAGE_FORMAT;
    private static int suffix = 2;

    private ImageService() {
    }

    public static String saveImage(byte[] imageData) throws IOException {
        Path directory = Paths.get(imageDirectory);

        // Create new directory if it doesn't already exist
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        // Generate a unique file name by appending a number suffix if necessary
        Path filePath = directory.resolve(imageName + "." + imageFormat); //2do: add dot to imageFormat again at fxml
        while (Files.exists(filePath)) {
            String fileName = imageName + "_" + suffix + imageFormat;
            filePath = directory.resolve(fileName);
            suffix++;
        }

        // Save image to local directory
        Files.write(filePath, imageData);

        return filePath.toString();
    }
}
