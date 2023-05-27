package org.fancylynx.application.config;

import javafx.stage.Stage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 2do: merge with "Configuration" class?
@Configuration
public class AppConfiguration {

    @Bean
    public Stage primaryStage() {
        return new Stage();
    }

}

//    @Bean
//    public DataModel dataModel() {
//        // Return the appropriate instance of DataModel
//        return new DataModelManager();
//    }
//
//    @Bean
//    public TourModel tourModel(TourRepository tourRepository) {
//        // Return the appropriate instance of TourModel, injecting the TourRepository
//        return new TourModelManager(tourRepository);
//    }

//    @Bean
//    public ModelFactory modelFactory(TourModelManager tourModelManager, DataModelManager dataModelManager) {
//        // Return the appropriate instance of ModelFactory, injecting the TourModel and DataModel
//        return new ModelFactory(tourModelManager, dataModelManager);
//    }

//    @Bean
//    public ViewModelFactory viewModelFactory(ModelFactory modelFactory) {
//        // Return the appropriate instance of ViewModelFactory, injecting the ModelFactory
//        return new ViewModelFactory(modelFactory);
//    }


//
//    @Bean
//    public ViewHandler viewHandler(Stage stage, ViewModelFactory viewModelFactory) {
//        // Return the appropriate instance of ViewHandler, injecting the Stage and ViewModelFactory
//        return new ViewHandler(stage, viewModelFactory);
//    }

//}
