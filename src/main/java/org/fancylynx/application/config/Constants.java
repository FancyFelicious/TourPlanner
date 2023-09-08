package org.fancylynx.application.config;

public final class Constants {

    // API Endpoints
    public static final String MAP_QUEST_ENDPOINT_DIRECTIONS = "https://www.mapquestapi.com/directions/v2/route";
    public static final String MAP_QUEST_ENDPOINT_STATICMAP = "https://www.mapquestapi.com/staticmap/v5/map";

    // Default Image Settings (Tour Map)
    public static final String DEFAULT_IMAGE_SAVE_DIRECTORY = "images/";
    public static final String DEFAULT_IMAGE_NAME = "TourMap";
    // File extensions
    public static final String FILE_EXTENSION_PNG = "png";
    public static final String DEFAULT_IMAGE_FORMAT = FILE_EXTENSION_PNG;
    public static final String FILE_EXTENSION_JPG = "jpg";
    public static final String FILE_EXTENSION_JPEG = "jpeg";
    
    // Prevents other classes from creating instances of 'Constants' (this is supposed to be a collection of constant values rather than an object with a state)
    private Constants() {
    }
}