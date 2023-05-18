package org.fancylynx.playground;

public final class Constants {
    public static final String PATH_TO_SQL_INIT_FILE = "src/main/resources/DB_init.sql";

    // Prevents other classes from creating instances of 'Constants' (this is supposed to be a collection of constant values rather than an object with a state)
    private Constants() {
    }
}