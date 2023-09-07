package org.fancylynx.application.BL.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fancylynx.application.BL.model.tour.RouteModel;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.config.Constants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class RouteServiceImpl implements RouteService {
    public RouteModel getRoute(TourModelNew tour) {
        // 2do: implement .png / transport type options
        // Generate request URL
        String endpoint = Constants.MAP_QUEST_ENDPOINT_DIRECTIONS;
        String apiKey = System.getProperty("MAP_QUEST_API_KEY");
        String requestUrl = endpoint + "?key=" + apiKey + "&from=" + tour.getFrom() + "&to=" + tour.getTo() + "&transportMode=" + tour.getTransportType(); //2do more options

        System.out.println("DEBUG - GENERATED REQUEST URL:");
        System.out.println(requestUrl);

        // Get response
        WebClient.RequestHeadersUriSpec<?> requestSpec = WebClient.builder().baseUrl(requestUrl).build().get();
        String responseBody = requestSpec.retrieve().bodyToMono(String.class).block();
        // 2o needed?
//        HttpHeaders responseHeaders = requestSpec.exchangeToMono(response -> Mono.just(response.headers().asHttpHeaders())).block();
//        HttpStatusCode statusCode = requestSpec.exchangeToMono(response -> Mono.just(response.statusCode())).block();

        // 2do: error handling
//        if statusCode >= 400 throw exception // 2do
        // Extract session ID
        String sessionId = " - ";
        Double distance;
        long time;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            sessionId = jsonNode.get("route").get("sessionId").asText();
            distance = jsonNode.get("route").get("distance").asDouble();
            time = jsonNode.get("route").get("time").asLong();

            return new RouteModel(sessionId, distance, time);
        } catch (Exception e) {
            System.out.println("ok nicht cool: " + e.getMessage()); // 2do
        }

        return null;
    }

    public String getStaticMap(String sessionId) {
        String endpoint = Constants.MAP_QUEST_ENDPOINT_STATICMAP;
        String apiKey = System.getProperty("MAP_QUEST_API_KEY");
        String requestUrl = endpoint + "?format=" + ImageService.imageFormat + "&key=" + URLEncoder.encode(apiKey, StandardCharsets.UTF_8) + "&session=" + URLEncoder.encode(sessionId, StandardCharsets.UTF_8);

        System.out.println("DEBUG - GENERATED REQUEST URL:");
        System.out.println(requestUrl);

        WebClient.RequestHeadersUriSpec<?> requestSpec = WebClient.builder().baseUrl(requestUrl).build().get();

//        HttpStatusCode statusCode = requestSpec.exchangeToMono(response -> Mono.just(response.statusCode())).block();
//        HttpHeaders testHeaders2 = okcool2.exchangeToMono(response -> Mono.just(response.headers().asHttpHeaders())).block();
//        String responseBody = requestSpec.retrieve().bodyToMono(String.class).block();

        // Convert response body string to byte array & save image to file system
        byte[] imageData = requestSpec.retrieve().bodyToMono(byte[].class).block();
        String imagePath = "";
        try {
            imagePath = ImageService.saveImage(imageData);
        } catch (IOException e) {
            e.printStackTrace(); // 2do
        }
        return imagePath;
    }
}
