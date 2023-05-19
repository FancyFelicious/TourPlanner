package org.fancylynx.playground;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fancylynx.application.model.Tour;
import org.fancylynx.application.service.SaveImageToFileSystem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

//@Service
public class APIPlayground {
//    //    private static WebClient webClient = null;
//    private final WebClient webClient;

//    @Autowired
//    public APIPlayground(WebClient.Builder webClientBuilder) {
//        webClient = webClientBuilder.build();
//    }

    public void run() throws IOException {

        Tour testTour = new Tour();
        testTour.setFrom("vienna");
        testTour.setTo("madrid");
        String baseUrl = "https://www.mapquestapi.com/directions/v2/route";
        String apiKey = System.getProperty("MAP_QUEST_API_KEY"); // "R9fOD3ja6eTQpWBEQCLiYyWr3OecThSh";
        String url = baseUrl + "?key=" + apiKey + "&from=" + testTour.getFrom() + "&to=" + testTour.getTo();

        System.out.println("XXXXXXXXXXXXXX URL XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(url);


//        WebClient.Builder builder = WebClient.builder();
        WebClient.RequestHeadersUriSpec<?> okcool = WebClient.builder().baseUrl(url).build().get();
        String responseTest = okcool.retrieve().bodyToMono(String.class).block();
        HttpStatusCode testStatus = okcool.exchangeToMono(response -> Mono.just(response.statusCode())).block();
        HttpHeaders testHeaders = okcool.exchangeToMono(response -> Mono.just(response.headers().asHttpHeaders())).block();

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX body XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(responseTest);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX status XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(testStatus);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX headers XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(testHeaders);

//
        System.out.println("---------------------------------------------------------");
//        JSON to Jackson JsonNode
        System.out.println("JSON to Jackson JsonNode");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseTest);
        String sessionId = jsonNode.get("route").get("sessionId").asText();
        System.out.println(jsonNode);
        System.out.println(sessionId);
        System.out.println("---------------------------------------------------------");

        String testReq = "https://www.mapquestapi.com/staticmap/v5/map?format=png&key=" + URLEncoder.encode(apiKey, StandardCharsets.UTF_8) + "&session=" + URLEncoder.encode(sessionId, StandardCharsets.UTF_8);
        System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY 1 YYYYYYYYYYYYYYYYYYYYYYYYYYY");
        System.out.println(testReq);
//        String testReqEncoded = URLEncoder.encode(testReq, StandardCharsets.UTF_8);
//        System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY 2 YYYYYYYYYYYYYYYYYYYYYYYYYYY");
//        System.out.println(testReqEncoded);

        WebClient.RequestHeadersUriSpec<?> okcool2 = WebClient.builder().baseUrl(testReq).build().get();
        String responseTest2 = okcool2.retrieve().bodyToMono(String.class).block();
        HttpStatusCode testStatus2 = okcool2.exchangeToMono(response -> Mono.just(response.statusCode())).block();
        HttpHeaders testHeaders2 = okcool2.exchangeToMono(response -> Mono.just(response.headers().asHttpHeaders())).block();

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX body XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        System.out.println(responseTest2);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX status XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(testStatus2);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX headers XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(testHeaders2);

        // Convert the response body string to a byte array
//        System.out.println(responseTest2);
        byte[] imageData = okcool2.retrieve().bodyToMono(byte[].class).block();
        try {
            SaveImageToFileSystem.save(imageData);
        } catch (IOException e) {
            // 2do
            e.printStackTrace();
        }

//        // Path to save the JPEG file
//        String filePath = "testDir/image.jpeg";
//
//        try {
//            // Create a FileOutputStream to write the byte array to the file
//            FileOutputStream fos = new FileOutputStream(filePath);
//
//            // Write the byte array to the file
//            fos.write(imageData);
//
//            // Close the FileOutputStream
//            fos.close();
//
//            System.out.println("Image saved successfully.");
//        } catch (IOException e) {
//            System.out.println("Error occurred while saving the image: " + e.getMessage());
//        }


//
//        String okStringTest = "https://www.mapquestapi.com/staticmap/v5/map?key=" + apiKey + "&session=" + sessionId;
//        System.out.println(okStringTest);

//        String responseTest2 = builder.build().get()
//                .uri(url)
//                .retrieve()
//                .bodyToMono(String.class).block();


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


//    WebClient.Builder builder = WebClient.builder();
//        WebClient.RequestHeadersUriSpec<?> okcool = WebClient.builder().baseUrl(url).build().get();
//        ClientResponse response = okcool.exchangeToMono(Mono::just).block();
//
//        if (response != null) {
//            System.out.println("cool");
//            Mono<String> responseBodyMono = response.bodyToMono(String.class);
//
////            String responseBodyTest = responseBodyMono.block();
////            System.out.println(responseBodyTest);
//            HttpHeaders responsHeaderTest = response.headers().asHttpHeaders();
//            System.out.println(responsHeaderTest);
//            HttpStatusCode statusCode = response.statusCode();
//            System.out.println(statusCode);
//
//        } else {
//            System.out.println("nah");
//        }

//        okcool.retrieve().bodyToMono(String.class).block();
//
//        WebClient webClient = WebClient.builder().build();
//        ClientResponse response = webClient.get().uri(url).exchangeToMono(Mono::just).block();
//
//
//        System.out.println("das is raw response");
//        System.out.println(response);
//
//
//        if (response != null) {
//            String responseBody = response.bodyToMono(String.class).block();
//            System.out.println("Response Body: " + responseBody);
//            HttpStatusCode statusCode = response.statusCode();
//            System.out.println("Status Code: " + statusCode);
//
//            HttpHeaders headers = response.headers().asHttpHeaders();
//            System.out.println("Headers: " + headers);
//        } else {
//            System.out.println("Failed to receive response");
//        }


//        String responseTest = builder.baseUrl(url).build().get()
//                .retrieve()
//                .bodyToMono(String.class).block();
//
//        HttpStatusCode teststatus = WebClient.builder().baseUrl(url).build()
//                .get().exchangeToMono(response -> Mono.just(response.statusCode()))
//                .block();

//        Mono<HttpHeaders> result = webClient.get()
//                .uri("/example")
//                .exchange()
//                .map(response -> response.headers().asHttpHeaders());

    }
}