package org.fancylynx.application.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource implements DatabaseConnector {
    private static DataSource dataSource;
    private final HikariDataSource hikariDataSource;

    private DataSource() {
        HikariConfig config = new HikariConfig("src/main/resources/hikari.properties");
        this.hikariDataSource = new HikariDataSource(config);
    }

    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    public Connection getConnection() {
        try {
            return hikariDataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException("Database not available", e);
        }
    }
}
