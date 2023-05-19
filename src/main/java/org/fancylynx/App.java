package org.fancylynx;

import org.fancylynx.application.config.Configuration;
import org.fancylynx.playground.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;


@SpringBootApplication
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("whazzup app startet etc");
        System.out.println("LOAD CONFIG");
        Configuration.load();


//        APIPlayground.run();


        SpringApplication.run(App.class, args);

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        APIPlayground apiPlayground = new APIPlayground(WebClient.builder());
        apiPlayground.run();
        
//        SpringApplication tourPlanner = new SpringApplication(App.class);
//        tourPlanner.setDefaultProperties(dotenv.get());
//        tourPlanner.run(args);


//        SpringTestRepository springTestRepository;
//        SpringTest springTest = new SpringTest(1, "test", "test description");
//        springTestRepository.save(springTest);

        TestClass2 testClass1 = new TestClass2("ok", 4, 5);
        TestClass2 testClass2 = new TestClass2("ok2", 7, 9);
        TestClass2 testClass3 = new TestClass2("ok", 4, 5);

        String env = System.getenv("JAVA_HOME");
        System.out.println("java home env path:");
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

    @Bean
    CommandLineRunner commandLineRunner(SpringTestRepository springTestRepository) {
        return args -> {
            System.out.println("HE HALLO ICH BIN HIER OK");
            SpringTest springTest = new SpringTest(1, "test", "test description");
            SpringTest springTest2 = new SpringTest(2, "test22", "test description222");
            SpringTest springTest3 = new SpringTest(3, "test333", "test description33333");

            springTestRepository.save(springTest);
            springTestRepository.save(springTest2);
            springTestRepository.save(springTest3);

            List<SpringTest> testHier = springTestRepository.findAll();
            System.out.println("HE HALLO ICH BIN HIER OK222222");

            System.out.println(testHier);
            for (SpringTest test : testHier) {
                // Access the properties or perform operations on each SpringTest object
                long id = test.getId();
                String name = test.getName();
                String description = test.getDescription();

                // Do something with the properties
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Description: " + description);
            }
        };
    }
}
