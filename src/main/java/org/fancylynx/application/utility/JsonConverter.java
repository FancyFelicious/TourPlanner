package org.fancylynx.application.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.fancylynx.application.BL.model.tour.TourModelNew;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonConverter {
    public static void writeToJsonFile(TourModelNew tour, String filePath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        // For Java 8 Date/Time Support
        objectMapper.registerModule(new JavaTimeModule());

        String json = objectMapper.writeValueAsString(tour);

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TourModelNew readFromJsonFile(File file) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        // For Java 8 Date/Time Support
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper.readValue(file, TourModelNew.class);
    }
}
