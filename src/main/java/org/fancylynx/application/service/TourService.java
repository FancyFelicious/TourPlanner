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

@Service
public class TourService {
    public String getRoute(Tour tour) {
        String endpoint = Constants.MAP_QUEST_ENDPOINT_DIRECTIONS;
        String apiKey = System.getProperty("MAP_QUEST_API_KEY");
        String requestUrl = endpoint + "?key=" + apiKey + "&from=" + tour.getOrigin() + "&to=" + tour.getDestination();

//        System.out.println("XXXXXXXXXXXXXX URL XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        System.out.println(requestUri);
//        WebClient.Builder builder = WebClient.builder();

        WebClient.RequestHeadersUriSpec<?> requestSpec = WebClient.builder().baseUrl(requestUrl).build().get();
        String responseBody = requestSpec.retrieve().bodyToMono(String.class).block();
        HttpHeaders responseHeaders = requestSpec.exchangeToMono(response -> Mono.just(response.headers().asHttpHeaders())).block();
        HttpStatusCode statusCode = requestSpec.exchangeToMono(response -> Mono.just(response.statusCode())).block();

//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX body XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        System.out.println(responseBody);
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX status XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        System.out.println(statusCode);
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX headers XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        System.out.println(responseHeaders);

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

    public String getStaticMap(String sessionId) {

//        String testReq = Constants.MAP_QUEST_BASE_URL_STATICMAP + "?format=png&key=" + URLEncoder.encode(apiKey, StandardCharsets.UTF_8) + "&session=" + URLEncoder.encode(sessionId, StandardCharsets.UTF_8);
//        System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY 1 YYYYYYYYYYYYYYYYYYYYYYYYYYY");
//        System.out.println(testReq);
////        String testReqEncoded = URLEncoder.encode(testReq, StandardCharsets.UTF_8);
////        System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY 2 YYYYYYYYYYYYYYYYYYYYYYYYYYY");
////        System.out.println(testReqEncoded);
//
//        WebClient.RequestHeadersUriSpec<?> okcool2 = WebClient.builder().baseUrl(testReq).build().get();
//        String responseTest2 = okcool2.retrieve().bodyToMono(String.class).block();
//        HttpStatusCode testStatus2 = okcool2.exchangeToMono(response -> Mono.just(response.statusCode())).block();
//        HttpHeaders testHeaders2 = okcool2.exchangeToMono(response -> Mono.just(response.headers().asHttpHeaders())).block();
//
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX body XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
////        System.out.println(responseTest2);
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX status XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        System.out.println(testStatus2);
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX headers XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        System.out.println(testHeaders2);
//
//        // Convert the response body string to a byte array
////        System.out.println(responseTest2);
//        byte[] imageData = okcool2.retrieve().bodyToMono(byte[].class).block();
//        try {
//            SaveImageToFileSystem.save(imageData);
//        } catch (SaveImageException e) {
//            // 2do
//            e.printStackTrace();
//        }
        return "test - " + sessionId;
    }
}
