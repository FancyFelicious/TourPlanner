package org.fancylynx;

import org.fancylynx.playground.SerializationTest;
import org.fancylynx.playground.TestClass2;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("whazzup app startet etc");

        TestClass2 testClass1 = new TestClass2("ok", 4, 5);
        TestClass2 testClass2 = new TestClass2("ok2", 7, 9);
        TestClass2 testClass3 = new TestClass2("ok", 4, 5);

        String env = System.getenv("JAVA_HOME");
        System.out.println("ok hierp ls");
        System.out.println("ok hierp ls");

        System.out.println(env);

        System.out.println(testClass1.testInt1());
        System.out.println(testClass1.testInt2());
        System.out.println("das is hash:");
        System.out.println(testClass1.hashCode());
        System.out.println("print class:");
        System.out.println(testClass1);
        System.out.println("print getClass:");
        System.out.println(testClass1.getClass());

        System.out.println("should not be equal:");
        System.out.println(testClass1.equals(testClass2));
        System.out.println("should be equal:");
        System.out.println(testClass1.equals(testClass3));


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
