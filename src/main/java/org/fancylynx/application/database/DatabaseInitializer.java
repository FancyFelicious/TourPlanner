//package org.fancylynx.application.database;
//
//import org.apache.ibatis.jdbc.ScriptRunner;
//import org.fancylynx.application.config.Constants;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.Reader;
//import java.sql.Connection;
//
//public class DatabaseInitializer {
//    public static void init() throws Exception {
//        // Connect to database
//        DatabaseConnector databaseConnector = DataSource.getInstance();
//        Connection connection = databaseConnector.getConnection();
//
//        // Initialize database / read DB_init.sql script
//        ScriptRunner sr = new ScriptRunner(connection);
//        Reader reader = new BufferedReader(new FileReader(Constants.PATH_TO_SQL_INIT_FILE));
//        sr.runScript(reader);
//    }
//}
