package org.fancylynx.application.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Configuration {
    private Configuration() {
    }

    // Set JVM environment variables - pulled from .env file
    public static void loadAppConfiguration() {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }
}
