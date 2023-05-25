package org.fancylynx.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fancylynx.application.config.Constants;
import org.fancylynx.application.entity.Tour;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class TourService {
    public String getRoute(Tour tour) {
        String endpoint = Constants.MAP_QUEST_ENDPOINT_DIRECTIONS;
        String apiKey = System.getProperty("MAP_QUEST_API_KEY");
        String requestUrl = endpoint + "?key=" + apiKey + "&from=" + tour.getOrigin() + "&to=" + tour.getDestination(); //2do more options

        WebClient.RequestHeadersUriSpec<?> requestSpec = WebClient.builder().baseUrl(requestUrl).build().get();
        String responseBody = requestSpec.retrieve().bodyToMono(String.class).block();

        //2o needed?
        HttpHeaders responseHeaders = requestSpec.exchangeToMono(response -> Mono.just(response.headers().asHttpHeaders())).block();
        HttpStatusCode statusCode = requestSpec.exchangeToMono(response -> Mono.just(response.statusCode())).block();

//        if statusCode >= 400 throw exception // 2do
        // headers notwendig?

        String sessionId = " - ";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            sessionId = jsonNode.get("route").get("sessionId").asText();
        } catch (Exception e) {
            System.out.println("ok nicht cool: " + e.getMessage()); // 2do
        }

        return sessionId;
    }

    // 2do: merge into one function?
    public String getStaticMap(String sessionId) {
        System.out.println("OK ICH BIN HIEROIFJIODSF");
        String endpoint = Constants.MAP_QUEST_ENDPOINT_STATICMAP;
        String apiKey = System.getProperty("MAP_QUEST_API_KEY");
        String requestUrl = endpoint + "?format=png&key=" + URLEncoder.encode(apiKey, StandardCharsets.UTF_8) + "&session=" + URLEncoder.encode(sessionId, StandardCharsets.UTF_8);

//        String testReqEncoded = URLEncoder.encode(testReq, StandardCharsets.UTF_8);

        System.out.println("REQUEST URL: ");
        System.out.println(requestUrl);

        WebClient.RequestHeadersUriSpec<?> requestSpec = WebClient.builder().baseUrl(requestUrl).build().get();
//        HttpStatusCode statusCode = requestSpec.exchangeToMono(response -> Mono.just(response.statusCode())).block();
//
//        HttpHeaders testHeaders2 = okcool2.exchangeToMono(response -> Mono.just(response.headers().asHttpHeaders())).block();
//        String responseBody = requestSpec.retrieve().bodyToMono(String.class).block();

        System.out.println("UND DANACH ");

        // Convert the response body string to a byte array
//        System.out.println(responseTest2);
        byte[] imageData = requestSpec.retrieve().bodyToMono(byte[].class).block();
        String imagePath = "";
        try {
            System.out.println("ANFANG COM TRY BLOCKSDFJOSDFJ");
            imagePath = ImageService.saveImage(imageData);
        } catch (IOException e) {
            // 2do
            e.printStackTrace();
        }
        System.out.println("OK UND HIER UACH NOCHAPFJSDKF OJASDFOÖJSFODSÖJF");
        return imagePath;
    }
}
