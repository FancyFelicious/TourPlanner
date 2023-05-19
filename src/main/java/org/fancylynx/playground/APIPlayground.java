package org.fancylynx.playground;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fancylynx.application.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class APIPlayground {
    //    private static WebClient webClient = null;
    private final WebClient webClient;

    @Autowired
    public APIPlayground(WebClient.Builder webClientBuilder) {
        webClient = webClientBuilder.build();
    }

    public void run() throws JsonProcessingException {

        Tour testTour = new Tour();
        testTour.setFrom("vienna");
        testTour.setTo("moscow");
        String baseUrl = "https://www.mapquestapi.com/directions/v2/route";
        String apiKey = System.getProperty("MAP_QUEST_API_KEY"); // "R9fOD3ja6eTQpWBEQCLiYyWr3OecThSh";
        String url = baseUrl + "?key=" + apiKey + "&from=" + testTour.getFrom() + "&to=" + testTour.getTo();

//        String urlTest = "https://www.mapquestapi.com/directions/v2/route?key=R9fOD3ja6eTQpWBEQCLiYyWr3OecThSh&from=wien&to=rom";

//        WebClient webClient = WebClient.create();
        WebClient.Builder builder = WebClient.builder();

        String responseTest = builder.build().get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class).block();

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX RAW RESPONSE XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(responseTest);

        System.out.println("---------------------------------------------------------");
//        JSON to Jackson JsonNode
        System.out.println("JSON to Jackson JsonNode");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseTest);
        String sessionId = jsonNode.get("route").get("sessionId").asText();
        System.out.println(jsonNode);
        System.out.println(sessionId);
        System.out.println("---------------------------------------------------------");
////        Creating a Java List From a JSON Array String
//        System.out.println("LIST FROM JSON");
////        List listCar = objectMapper.readValue(responseTest) {
////        });
////        System.out.println(listCar);
//        System.out.println("---------------------------------------------------------");
//        //        Creating Java Map From JSON String
//        System.out.println("Creating Java Map From JSON String");
//        Map<String, Object> map
//                = objectMapper.readValue(responseTest, new TypeReference<Map<String, Object>>() {
//        });
//        System.out.println(map);
//        System.out.println(map.get("route").get("sessionId"));
//        System.out.println("---------------------------------------------------------");


//        try {
//            UserList userList = objectMapper.readValue(responseTest, UserList.class);
//            for (User user : userList.getUsers()) {
//                System.out.println(user);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            Map<String, Object> jsonData = objectMapper.readValue(responseTest, Map.class);
//
//            // Access the parsed JSON data
//            Map<String, Object> route = (Map<String, Object>) jsonData.get("route");
//            boolean hasTollRoad = (boolean) route.get("hasTollRoad");
//            double fuelUsed = (double) route.get("fuelUsed");
//
//            System.out.println("Has Toll Road: " + hasTollRoad);
//            System.out.println("Fuel Used: " + fuelUsed);
//
//            System.out.println("JSON DATA RAW");
//            System.out.println(jsonData);
//
//            // Access other properties as needed
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        // Make the API call and get the response
//        Mono<ClientResponse> responseMono = webClient.get().uri(baseUrl).exchangeToMono();
//        // Block and get the response
//        ClientResponse response = responseMono.block();
//        // Get the response status code
//        HttpStatus statusCode = (HttpStatus) response.statusCode();
//        System.out.println("Response Code: " + statusCode);
//        // Get the response headers
//        HttpHeaders headers = response.headers().asHttpHeaders();
//        System.out.println("Response Headers: " + headers);
//        // Get the response body
//        Mono<String> responseBodyMono = response.bodyToMono(String.class);
//        String responseBody = responseBodyMono.block();
//        System.out.println("Response Body: " + responseBody);

//        // Process the response body
//        System.out.println("OKOKOKOKOKOKOKOK");
//        System.out.println(url);
//        webClient.get()
//                .uri(url)
//                .retrieve()
//                .bodyToMono(String.class)
//                .subscribe(System.out::println);

    }
}
