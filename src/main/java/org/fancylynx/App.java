package org.fancylynx;

import org.fancylynx.application.config.Configuration;
import org.fancylynx.application.view.monolith.Monolith;
import org.fancylynx.playground.JPAPlaygroundRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("whazzup app startet etc");

        System.out.println("LOAD APP CONFIG");
        Configuration.loadAppConfiguration();

        System.out.println("START SPRING APP");
        SpringApplication.run(App.class, args);
        // SpringApplication tourPlanner = new SpringApplication(App.class);
        // tourPlanner.setDefaultProperties(dotenv.get());
        // tourPlanner.run(args);

        Monolith.launch(Monolith.class, args);
//        ScreenTestBase.launch(ScreenTestBase.class, args);
//        GenericBaseApplication.launch(GenericBaseApplication.class, args);
//        SetValuesFXPlayground.launch(SetValuesFXPlayground.class, args);
//        HomeScreen.launch(HomeScreen.class, args);

//        UserInterface.launch(UserInterface.class, args);
//        genericBaseApplication.start(new Stage());


//        System.out.println("TESTING / PLAYGROUND / TRASH / ARCHIVE");
//        System.out.println("XXXXXXXX API XXXXXXXX");
//        APIPlayground apiPlayground = new APIPlayground();
//        apiPlayground.run();
//
//        System.out.println(" XXXXXXXX DOTENV XXXXXXXX");
//        String env = System.getenv("JAVA_HOME");
//        System.out.println("java home env path:");
//        System.out.println(env);
//
//        System.out.println("XXXXXXXX SERIALIZATION XXXXXXXX");
//        SerializationTest.run();


//        helloApplication.start(new Stage());
//        System.out.println("shut down");
//        }
    }

    @Bean
    CommandLineRunner commandLineRunner(JPAPlaygroundRepository JPAPlaygroundRepository) {
        return args -> {
            System.out.println(" XXXXXXXX COMMAND LINE RUNNER / SAVE TO DB XXXXXXXX");
//            JPAPlayground JPAPlayground = new JPAPlayground(1, "test", "test description");
//            JPAPlayground JPAPlayground2 = new JPAPlayground(2, "test22", "test description222");
//            JPAPlayground JPAPlayground3 = new JPAPlayground(3, "test333", "test description33333");
//            JPAPlaygroundRepository.save(JPAPlayground);
//            JPAPlaygroundRepository.save(JPAPlayground2);
//            JPAPlaygroundRepository.save(JPAPlayground3);
//
//            System.out.println("FIND ALL");
//            List<JPAPlayground> testHier = JPAPlaygroundRepository.findAll();
//            System.out.println(testHier);
//            for (JPAPlayground test : testHier) {
//                long id = test.getId();
//                String name = test.getName();
//                String description = test.getDescription();
//
//                System.out.println("ID: " + id);
//                System.out.println("Name: " + name);
//                System.out.println("Description: " + description);
//            }
        };
    }
}
