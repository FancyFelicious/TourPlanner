package at.technikum.tourplanner.playground;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializationTest {
    public static void run() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            UserList userList = objectMapper.readValue(new File("src/main/java/at/technikum/tourplanner/playground/ok123.json"), UserList.class);
            for (User user : userList.getUsers()) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }
}

class UserList {
    private List<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

class User {
    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
