package org.fancylynx.application.view.MVVMPlayground.factory;

import org.fancylynx.application.view.MVVMPlayground.model.DataModel;
import org.fancylynx.application.view.MVVMPlayground.model.DataModelManager;

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
