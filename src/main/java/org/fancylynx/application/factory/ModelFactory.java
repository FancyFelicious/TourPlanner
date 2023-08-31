package org.fancylynx.application.factory;

import org.fancylynx.application.BL.model.DataModel;
import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.BL.model.tour.TourModelManager;
import org.springframework.stereotype.Component;

@Component
public class ModelFactory {
    private final DataModel dataModel;
    private final TourModel tourModel;

    public ModelFactory(TourModelManager tourModel, DataModel dataModel) {
        this.tourModel = tourModel;
        this.dataModel = dataModel;
    }

    //2do
    public TourModel getTourModel() {
        return tourModel;
    }

    public DataModel getDataModel() {
        return dataModel;
    }
}

// note: lazy approach
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
//}
