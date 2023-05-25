package org.fancylynx.playground.archive.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SerializationTest {
    public static void run() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            UserList userList = objectMapper.readValue(new File("src/main/java/org/fancylynx/playground/ok123.json"), UserList.class);
            for (User user : userList.getUsers()) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




