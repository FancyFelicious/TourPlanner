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
        System.out.println("KOMM ICH HIER REIN?");
        // Create the directory if it doesn't exist
        String directory = Configuration.getImageDirectory();
        System.out.println("1111111111111111111111111"); // 2do
        System.out.println(directory);

        Path imageDirectory = Paths.get(directory);
        System.out.println("222222222222222222222222"); // 2do

        if (!Files.exists(imageDirectory)) {
            Files.createDirectories(imageDirectory);
        }
        System.out.println("3333333333333333333333333"); // 2do


        // Generate a unique file name by appending a number suffix if necessary
        String format = Configuration.getImageFormat();
        String name = Configuration.getImageName();
        Path filePath = imageDirectory.resolve(name + format);
        System.out.println("4444444444444444444444444444"); // 2do

        while (Files.exists(filePath)) {
            String fileName = name + "_" + suffix + format;
            filePath = imageDirectory.resolve(fileName);
            suffix++;
        }

        System.out.println("5555555555555555555555"); // 2do

        // Save image to local directory
        Files.write(filePath, imageData);
        System.out.println("IMAGE SAVED OK NICE, HIER:"); // 2do
        System.out.println(filePath);

        return "lasdkf";
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

