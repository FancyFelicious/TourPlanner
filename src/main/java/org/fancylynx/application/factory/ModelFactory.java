package org.fancylynx.application.factory;

import org.fancylynx.application.model.DataModel;
import org.fancylynx.application.model.DataModelManager;
import org.springframework.stereotype.Component;

@Component
public class ModelFactory {
    // note: lazy
    private DataModel dataModel;

    public DataModel getDataModel() {
        if (dataModel == null) {
            dataModel = new DataModelManager();
        }
        return dataModel;
    }

//    public CustomerModel getDataModel() {
//        if (dataModel == null) {
//            dataModel = new CustomerModelManager();
//        }
//        return dataModel;
//    }
}
