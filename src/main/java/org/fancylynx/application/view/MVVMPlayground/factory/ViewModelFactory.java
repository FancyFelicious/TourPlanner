package org.fancylynx.application.view.MVVMPlayground.factory;

import org.fancylynx.application.view.MVVMPlayground.viewmodel.ClassXViewModel;

public class ViewModelFactory {
    private final ClassXViewModel classXViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        classXViewModel = new ClassXViewModel(modelFactory.getDataModel());
    }

    public ClassXViewModel getClassXViewModel() {
        return classXViewModel;
    }
}
