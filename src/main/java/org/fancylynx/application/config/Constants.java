package org.fancylynx.application.config;

// 2do: annotations?
public final class Constants {
    // public static final String PATH_TO_SQL_INIT_FILE = "src/main/resources/DB_init.sql";

    // Image Settings (Tour Details)
    public static final String FILE_EXTENSION_PNG = ".png";
    public static final String FILE_EXTENSION_JPG = ".jpg";
    public static final String FILE_EXTENSION_JPEG = ".jpeg";
    public static final String DEFAULT_IMAGE_SAVE_DIRECTORY = "images/";
    public static final String DEFAULT_IMAGE_NAME = "tourImage";
    public static final String DEFAULT_IMAGE_FORMAT = FILE_EXTENSION_PNG;

    // API Endpoints // 2do: put into .env file instead?
    public static final String MAP_QUEST_BASE_URL_DIRECTIONS = "https://www.mapquestapi.com/directions/v2/route";
    public static final String MAP_QUEST_BASE_URL_STATICMAP = "https://www.mapquestapi.com/staticmap/v5/map";

    // Stage Titles
    public static final String STAGE_TITLE_HOME = "Home";
    public static final String STAGE_TITLE_CREATE_TOUR = "Create Tour";

//    public static final String VIEW_FXML_FILE_HOME = "HomeView.fxml";
//    public static final String VIEW_FXML_FILE_CREATE_TOUR = "TourView.fxml";

    // Prevents other classes from creating instances of 'Constants' (this is supposed to be a collection of constant values rather than an object with a state)
    private Constants() {
    }
}