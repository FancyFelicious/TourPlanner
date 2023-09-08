package org.fancylynx.application.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.fancylynx.application.BL.model.tour.TourModel;

import java.io.File;

public class JsonConverter {

    public static TourModel readFromJsonFile(File file) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper.readValue(file, TourModel.class);
    }

    public static String convertToJson(TourModel tour) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // For Java 8 Date/Time Support
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper.writeValueAsString(tour);
    }
}
