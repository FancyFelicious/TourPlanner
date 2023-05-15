package org.fancylynx;

import org.fancylynx.playground.SerializationTest;
import org.fancylynx.playground.TestClass1;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("whazzup app startet etc");

        TestClass1 testClass1 = new TestClass1("ok", 4, 5);

        System.out.println(testClass1.testInt2());
        System.out.println(testClass1.testInt1());

        SerializationTest.run();

        System.out.println("yo1");
        GenericBaseApplication genericBaseApplication = new GenericBaseApplication();
        System.out.println("yo2");

        //        helloApplication.start(new Stage());
//        System.out.println("yo 3");

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
