package org.fancylynx.application.config;

// 2do: annotations?
public final class Constants {
    //    public static final String PATH_TO_SQL_INIT_FILE = "src/main/resources/DB_init.sql";
    public static final String DEFAULT_IMAGE_SAVE_DIRECTORY = "images/";
    public static final String DEFAULT_IMAGE_NAME = "tourImage";
    public static final String DEFAULT_IMAGE_FORMAT = ".png";
    public static final String MAP_QUEST_DIRECTIONS_BASE_URL = "https://www.mapquestapi.com/directions/v2/route";
    public static final String MAP_QUEST_STATIC_MAP_BASE_URL = "https://www.mapquestapi.com/staticmap/v5/map";


    // Prevents other classes from creating instances of 'Constants' (this is supposed to be a collection of constant values rather than an object with a state)
    private Constants() {
    }
}