package org.fancylynx.application.service;

import org.fancylynx.application.config.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveImageToFileSystem {
    private static String defaultDirectory = Constants.DEFAULT_IMAGE_SAVE_DIRECTORY;
    private static String defaultName = Constants.DEFAULT_IMAGE_NAME;
    private static String defaultFormat = Constants.DEFAULT_IMAGE_FORMAT;
    private static int suffix = 2;

    public static void save(byte[] imageData) throws IOException {
        // Create the directory if it doesn't exist
        Path directory = Paths.get(defaultDirectory);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        // Generate a unique file name by appending a number suffix if necessary
        Path filePath = directory.resolve(defaultName + defaultFormat);
        while (Files.exists(filePath)) {
            String fileName = defaultName + "_" + suffix + defaultFormat;
            filePath = directory.resolve(fileName);
            suffix++;
        }
        Files.write(filePath, imageData);
        System.out.println("IMAGE SAVED OK NICE, HIER:"); // 2do
        System.out.println(filePath);

    }

    public static void setDefaultDirectory(String defaultDirectory) {
        SaveImageToFileSystem.defaultDirectory = defaultDirectory;
    }

    public static void setDefaultName(String defaultName) {
        SaveImageToFileSystem.defaultName = defaultName;
    }

    public static void setDefaultFormat(String defaultFormat) {
        SaveImageToFileSystem.defaultFormat = defaultFormat;
    }
}

