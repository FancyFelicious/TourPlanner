package org.fancylynx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fancylynx.application.config.Configuration;
import org.fancylynx.application.factory.ModelFactory;
import org.fancylynx.application.model.DataModelManager;
import org.fancylynx.application.view.ViewHandler;
import org.fancylynx.playground.archive.AutoUpdater;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;

@SpringBootApplication
public class TourPlanner extends Application {
    public static void main(String[] args) throws IOException {
        Configuration.loadAppConfiguration();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TourPlanner.class);

        // Dependency Injection
        //ViewHandler viewHandler = applicationContext.getBean(ViewHandler.class);
        //viewHandler.start();

        Parent root = FXMLDependencyInjection.load(
                "MainView.fxml",
                Locale.GERMAN,
                applicationContext);  // Locale.GERMANY, Locale.ENGLISH

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // 2do: remove later - testing / simulating changes to db
        //ModelFactory modelFactory = applicationContext.getBean(ModelFactory.class);
        //runAutoUpdate((DataModelManager) modelFactory.getDataModel());
    }

    private void runAutoUpdate(DataModelManager dataModelManager) {
        AutoUpdater autoUpdater = new AutoUpdater(dataModelManager);
        Thread thread = new Thread(() -> {
            Random random = new Random();
            while (true) {

                // Note: In JavaFX, all UI updates must be performed on the Application Thread
                Platform.runLater(dataModelManager::recalculateData);

                try {
                    Thread.sleep(random.nextInt(5000) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}


// 2do: delete
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

