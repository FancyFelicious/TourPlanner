package org.fancylynx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.fancylynx.application.config.Configuration;
import org.fancylynx.application.factory.ModelFactory;
import org.fancylynx.application.factory.ViewModelFactory;
import org.fancylynx.application.model.DataModelManager;
import org.fancylynx.application.view.ViewHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class LaunchApp extends Application {
    public static void main(String[] args) throws IOException {
        System.out.println("LOAD APP CONFIG");
        Configuration.loadAppConfiguration();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(LaunchApp.class);

        // 2do: Dependency Injection?
        ViewModelFactory viewModelFactory = applicationContext.getBean(ViewModelFactory.class);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);

        ModelFactory modelFactory = applicationContext.getBean(ModelFactory.class);

        viewHandler.start();


        runAutoUpdate((DataModelManager) modelFactory.getDataModel());


    }

    // 2do: remove later - testing / simulating changes to db
    private void runAutoUpdate(DataModelManager m) {
        AutoUpdater autoUpdater = new AutoUpdater(m);
        Thread thread = new Thread(autoUpdater);
        thread.setDaemon(true);
        thread.start();
    }

//    @Bean
//    CommandLineRunner commandLineRunner(JPAPlaygroundRepository JPAPlaygroundRepository) {
//        return args -> {
//            System.out.println(" XXXXXXXX COMMAND LINE RUNNER / SAVE TO DB XXXXXXXX");
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
//        };
//    }
}


//        System.out.println("TESTING / PLAYGROUND / TRASH / ARCHIVE");
//
////        System.out.println("XXXXXXXX JAVAFX / MVVM XXXXXXXX");
////        Monolith.launch(Monolith.class, args);
//
//        System.out.println("XXXXXXXX API XXXXXXXX");
//        APIPlayground apiPlayground = new APIPlayground();
//        apiPlayground.run();
////
////        System.out.println(" XXXXXXXX DOTENV XXXXXXXX");
////        String env = System.getenv("JAVA_HOME");
////        System.out.println("java home env path:");
////        System.out.println(env);
////
////        System.out.println("XXXXXXXX SERIALIZATION XXXXXXXX");
////        SerializationTest.run();
//
////        System.out.println("shut down");
////        }
//    }
//

//}


//        SpringApplication.run(Entry.class, args);
// SpringApplication tourPlanner = new SpringApplication(App.class);
// tourPlanner.setDefaultProperties(dotenv.get());
// tourPlanner.run(args);
