package org.fancylynx.application.BL.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fancylynx.application.BL.model.tour.RouteModel;
import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.config.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class RouteServiceImpl implements RouteService {
    public RouteModel getRoute(TourModel tour) {
        // Generate request URL
        String endpoint = Constants.MAP_QUEST_ENDPOINT_DIRECTIONS;
        String apiKey = System.getProperty("MAP_QUEST_API_KEY");
        String requestUrl = endpoint + "?key=" + apiKey + "&from=" + tour.getFrom() + "&to=" + tour.getTo() + "&transportMode=" + tour.getTransportType(); //2do more options
        System.out.println("'Directions' request URL generated:");
        System.out.println(requestUrl);

        // Get response
        WebClient.RequestHeadersUriSpec<?> requestSpec = WebClient.builder().baseUrl(requestUrl).build().get();
        String responseBody = requestSpec.retrieve().bodyToMono(String.class).block();

        // Extract session ID
        String sessionId;
        double distance;
        long time;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            sessionId = jsonNode.get("route").get("sessionId").asText();
            distance = jsonNode.get("route").get("distance").asDouble();
            time = jsonNode.get("route").get("time").asLong();

            return new RouteModel(sessionId, distance, time);
        } catch (Exception e) {
            System.out.println("Unable to retrieve session ID from response body");
        }
        return null;
    }

    public String getStaticMap(String sessionId) {
        String endpoint = Constants.MAP_QUEST_ENDPOINT_STATICMAP;
        String apiKey = System.getProperty("MAP_QUEST_API_KEY");
        String requestUrl = endpoint + "?format=" + ImageService.imageFormat + "&key=" + URLEncoder.encode(apiKey, StandardCharsets.UTF_8) + "&session=" + URLEncoder.encode(sessionId, StandardCharsets.UTF_8);
        System.out.println("'Static Map' request URL generated:");
        System.out.println(requestUrl);

        // Convert response body string to byte array & save image to file system
        WebClient.RequestHeadersUriSpec<?> requestSpec = WebClient.builder().baseUrl(requestUrl).build().get();
        byte[] imageData = requestSpec.retrieve().bodyToMono(byte[].class).block();
        String imagePath = "";
        try {
            imagePath = ImageService.saveImage(imageData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath;
    }
}
