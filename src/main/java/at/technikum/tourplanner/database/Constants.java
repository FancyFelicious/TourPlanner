package at.technikum.tourplanner.database;

public class Constants {
    public static final String PATH_TO_SQL_INIT_FILE = "src/main/resources/DB_init.sql";
    public static final int COST_OF_CARD_PACKAGE = 5;

    // Prevents other classes from creating instances of 'Constants' (this is supposed to be a collection of constant values rather than an object with a state)
    private Constants() {
    }
}