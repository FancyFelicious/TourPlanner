package org.fancylynx.playground;

// 2do
public final class Constants {
    public static final String PATH_TO_SQL_INIT_FILE = "src/main/resources/DB_init.sql";
    public static final String DEFAULT_IMAGE_SAVE_DIRECTORY = "testDir/";
    public static final String DEFAULT_IMAGE_NAME = "testImage";
    public static final String DEFAULT_IMAGE_FORMAT = ".png";


    // Prevents other classes from creating instances of 'Constants' (this is supposed to be a collection of constant values rather than an object with a state)
    private Constants() {
    }
}