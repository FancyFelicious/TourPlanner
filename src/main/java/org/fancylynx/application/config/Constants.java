package org.fancylynx.application.config;

// 2do: annotations?
public final class Constants {

    // File extensions
    public static final String FILE_EXTENSION_PNG = "png";
    public static final String FILE_EXTENSION_JPG = "jpg";
    public static final String FILE_EXTENSION_JPEG = "jpeg";

    // Default Image Settings (Tour Map)
    public static final String DEFAULT_IMAGE_SAVE_DIRECTORY = "images/";
    public static final String DEFAULT_IMAGE_NAME = "Tour Map";
    public static final String DEFAULT_IMAGE_FORMAT = FILE_EXTENSION_PNG;
    public static final String DEFAULT_TOUR_MAP_PLACEHOLDER_IMAGE = "images/tourImage_PLACEHOLDER.png"; //2do

    // Transport Types
    public static final String TRANSPORT_TYPE_CAR = "car";
    public static final String TRANSPORT_TYPE_BICYCLE = "bicycle";
    public static final String TRANSPORT_TYPE_WALKING = "walking";

    // 2do: put into TourService class?
    // API Endpoints
    public static final String MAP_QUEST_ENDPOINT_DIRECTIONS = "https://www.mapquestapi.com/directions/v2/route";
    public static final String MAP_QUEST_ENDPOINT_STATICMAP = "https://www.mapquestapi.com/staticmap/v5/map";

    // Stage Titles
    public static final String STAGE_TITLE_HOME = "Home";
    public static final String STAGE_TITLE_CREATE_TOUR = "Create New Tour";

    public static final String STAGE_TITLE_MAIN = "Main";

    // 2do: put paths into constants or overkill?
//    public static final String VIEW_FXML_FILE_CREATE_TOUR = "TourView.fxml";

    // Prevents other classes from creating instances of 'Constants' (this is supposed to be a collection of constant values rather than an object with a state)
    private Constants() {
    }
}