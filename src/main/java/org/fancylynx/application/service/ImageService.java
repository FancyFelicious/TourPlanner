package org.fancylynx.application.service;

import org.fancylynx.application.config.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// 2do
public class ImageService {
    private static int suffix = 2;

    private ImageService() {
    }

    public static String saveImage(byte[] imageData) throws IOException {
        // Create the directory if it doesn't exist
        String directory = Configuration.imageDirectory;// Constants.DEFAULT_IMAGE_SAVE_DIRECTORY;

        System.out.println("directory: ");
        System.out.println(directory);


        Path imageDirectory = Paths.get(directory);
        System.out.println("imageDirectory: ");
        System.out.println(imageDirectory);

        if (!Files.exists(imageDirectory)) {
            Files.createDirectories(imageDirectory);
        }

        // Generate a unique file name by appending a number suffix if necessary
        String format = Configuration.imageFormat;
        String name = Configuration.imageName;
        Path filePath = imageDirectory.resolve(name + format);

        while (Files.exists(filePath)) {
            String fileName = name + "_" + suffix + format;
            filePath = imageDirectory.resolve(fileName);
            suffix++;
        }

        // Save image to local directory
        Files.write(filePath, imageData);

        System.out.println("filePath: ");
        System.out.println(filePath);

        return filePath.toString();
    }

//    public static void setDirectory(String directory) {
//        ImageService.directory = directory;
//    }
//
//    public static void setName(String name) {
//        ImageService.name = name;
//    }
//
//    public static void setFormat(String format) {
//        ImageService.format = format;
//    }
}

