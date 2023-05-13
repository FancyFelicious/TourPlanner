package at.technikum.tourplanner.database;

import java.sql.Connection;

public interface DatabaseConnector {
    Connection getConnection();
}