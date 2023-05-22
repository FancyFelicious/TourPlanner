package org.fancylynx.application.view.MVVMPlayground.viewmodel;

import org.fancylynx.application.view.MVVMPlayground.model.DataModel;
import org.springframework.stereotype.Component;

// 2do: make component, dependency injection
@Component
public class CreateTourViewModel {
    private final DataModel model;

    public CreateTourViewModel(DataModel model) {
        this.model = model;
    }
}
