package org.fancylynx.utility;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.utility.JsonConverter;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class JsonConverterTest {
    @Test
    public void tourToJson() throws Exception {
        TourModelNew tourModelNew = new TourModelNew(
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

        String json = JsonConverter.convertToJson(tourModelNew);

        assertEquals("{\"tourId\":124,\"name\":\"Tour 47\",\"description\":\"This is not a test\",\"from\":\"Vienna\",\"to\":\"France\",\"transportType\":\"Walking\",\"distance\":13.37,\"estimatedTime\":1234,\"imagePath\":\"someImagePath/1234.jpg\",\"tourLogs\":null}", json);
    }

    @Test
    public void jsonToTour() throws Exception {
        File file = new File("src/test/resources/utility/TestTour.json");

        TourModelNew tourModelNew = JsonConverter.readFromJsonFile(file);

        assertEquals(124, tourModelNew.getTourId());
        assertEquals("Tour 47", tourModelNew.getName());
        assertEquals("This is not a test", tourModelNew.getDescription());
        assertEquals("Vienna", tourModelNew.getFrom());
        assertEquals("France", tourModelNew.getTo());
        assertEquals("AUTO", tourModelNew.getTransportType());
        assertEquals(119.8035, tourModelNew.getDistance());
        assertEquals(1234, tourModelNew.getEstimatedTime());
        assertEquals("someImagePath/1234.jpg", tourModelNew.getImagePath());
    }
}
