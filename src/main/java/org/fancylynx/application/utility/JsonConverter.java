package org.fancylynx.application.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.fancylynx.application.BL.model.tour.TourModelNew;

import java.io.File;

public class JsonConverter {

    public static TourModelNew readFromJsonFile(File file) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper.readValue(file, TourModelNew.class);
    }

    public static String convertToJson(TourModelNew tour) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // For Java 8 Date/Time Support
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper.writeValueAsString(tour);
    }
}
