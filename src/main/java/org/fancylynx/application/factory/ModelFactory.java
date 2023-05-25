package org.fancylynx.application.factory;

import org.fancylynx.application.model.DataModel;
import org.fancylynx.application.model.DataModelManager;
import org.fancylynx.application.model.tour.TourModel;
import org.fancylynx.application.model.tour.TourModelManager;
import org.springframework.stereotype.Component;

@Component
public class ModelFactory {
    private final DataModelManager dataModelManager;
    private final TourModelManager tourModelManager;

    public ModelFactory(TourModelManager tourModelManager, DataModelManager dataModelManager) {
        this.tourModelManager = tourModelManager;
        this.dataModelManager = dataModelManager;
    }

    public TourModel getTourModel() {
        return tourModelManager;
    }

    public DataModel getDataModel() {
        return dataModelManager;
    }
}

// note: lazy
//    private TourModel tourModel;
//    private TourModelManager tourModelManager;
//    private TourRepository tourRepository;


//    public DataModel getDataModel() {
//        if (dataModel == null) {
//            dataModel = new DataModelManager();
//        }
//        return dataModel;
//    }
//
//    public TourModel getTourModel() {
//        if (tourModel == null) {
//            tourModel = new TourModelManager();
//        }
//        return tourModel;
//    }


//    public CustomerModel getDataModel() {
//        if (dataModel == null) {
//            dataModel = new CustomerModelManager();
//        }
//        return dataModel;
//    }
//}
