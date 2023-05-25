package org.fancylynx.application.service;

import org.fancylynx.application.config.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// 2do
public class SaveImageToFileSystem {
    private static String directory = Constants.DEFAULT_IMAGE_SAVE_DIRECTORY;
    private static String name = Constants.DEFAULT_IMAGE_NAME;
    private static String format = Constants.DEFAULT_IMAGE_FORMAT;
    private static int suffix = 2;

    public static void save(byte[] imageData) throws IOException {

        // Create the directory if it doesn't exist
        Path imageDirectory = Paths.get(directory);
        if (!Files.exists(imageDirectory)) {
            Files.createDirectories(imageDirectory);
        }

        // Generate a unique file name by appending a number suffix if necessary
        Path filePath = imageDirectory.resolve(name + format);
        while (Files.exists(filePath)) {
            String fileName = name + "_" + suffix + format;
            filePath = imageDirectory.resolve(fileName);
            suffix++;
        }

        // Save image to local directory
        Files.write(filePath, imageData);
        System.out.println("IMAGE SAVED OK NICE, HIER:"); // 2do
        System.out.println(filePath);

    }

    public static void setDirectory(String directory) {
        SaveImageToFileSystem.directory = directory;
    }

    public static void setName(String name) {
        SaveImageToFileSystem.name = name;
    }

    public static void setFormat(String format) {
        SaveImageToFileSystem.format = format;
    }
}

