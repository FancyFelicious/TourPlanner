package org.fancylynx.application.config;

import io.github.cdimascio.dotenv.Dotenv;

// 2do: different approach to load environment variables? (spring style) - see https://www.baeldung.com/spring-properties-file-outside-jar
//@org.springframework.context.annotation.Configuration
//@PropertySource("classpath:application.yaml")

public class Configuration {
    public static void load() {
        // Set JVM environment variables - pulled from .env
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }
}
