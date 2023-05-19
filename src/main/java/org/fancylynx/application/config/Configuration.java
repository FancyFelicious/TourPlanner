package org.fancylynx.application.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Configuration {
    public static void load() {
        // Set JVM environment variables - pulled from .env
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }
}
