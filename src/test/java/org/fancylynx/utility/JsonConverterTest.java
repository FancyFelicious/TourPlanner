package org.fancylynx.utility;

import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.utility.JsonConverter;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonConverterTest {
    @Test
    public void tourToJson() throws Exception {
        TourModel tourModel = new TourModel(
                124,
                "Tour 47",
                "This is not a test",
                "Vienna",
                "France",
                "Walking",
                13.37,
                1234,
                "someImagePath/1234.jpg"
        );

        String json = JsonConverter.convertToJson(tourModel);

        assertEquals("{\"tourId\":124,\"name\":\"Tour 47\",\"description\":\"This is not a test\",\"from\":\"Vienna\",\"to\":\"France\",\"transportType\":\"Walking\",\"distance\":13.37,\"estimatedTime\":1234,\"imagePath\":\"someImagePath/1234.jpg\",\"tourLogs\":null}", json);
    }

    @Test
    public void jsonToTour() throws Exception {
        File file = new File("src/test/resources/utility/TestTour.json");

        TourModel tourModel = JsonConverter.readFromJsonFile(file);

        assertEquals(124, tourModel.getTourId());
        assertEquals("Tour 47", tourModel.getName());
        assertEquals("This is not a test", tourModel.getDescription());
        assertEquals("Vienna", tourModel.getFrom());
        assertEquals("France", tourModel.getTo());
        assertEquals("AUTO", tourModel.getTransportType());
        assertEquals(119.8035, tourModel.getDistance());
        assertEquals(1234, tourModel.getEstimatedTime());
        assertEquals("someImagePath/1234.jpg", tourModel.getImagePath());
    }
}
