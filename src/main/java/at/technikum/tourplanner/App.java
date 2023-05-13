package at.technikum.tourplanner;

import at.technikum.tourplanner.playground.SerializationTest;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, worlddddddddd!");

        SerializationTest.run();


        System.out.println("yo 1");
        HelloApplication helloApplication = new HelloApplication();
        System.out.println("yo 2");
//        helloApplication.start(new Stage());
//        System.out.println("yo 3");


//        public static void main(String[] args) {
//            final int port = 2552;
////            Log.newEntry("App launched!", false);
////            Log.newEntry("Port set to: " + port, false);
//
//            // Initialize database
//            try {
//                DatabaseInitializer.init();
////                Log.newEntry("Database initialized", false);
//            } catch (Exception e) {
////                Log.newEntry("Error initializing database: " + e, false);
//                e.printStackTrace();
//            }
//
//            // Start server
//            Server server = new Server(port);
//            try {
////                Log.newEntry("Starting server...", false);
////                Log.newEntry("Listening to incoming requests on port " + port, false);
//                server.start();
//            } catch (Exception e) {
////                Log.newEntry("Error starting server (port " + port + ")" + e, false);
//                e.printStackTrace();
//            }
//
//            // Shut down application
////            Log.newEntry("Shutting down...", false);
//        }
    }
}
