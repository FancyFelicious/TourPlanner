package org.fancylynx.application.view;

import org.fancylynx.application.viewmodel.HomeViewModel;
import org.fancylynx.application.viewmodel.MainViewModel;

import java.io.IOException;

public class MainController {

    private ViewHandler viewHandler;
    private MainViewModel viewModel;

    public void init(MainViewModel mainViewModel, ViewHandler viewHandler) {
        this.viewModel = mainViewModel;
        this.viewHandler = viewHandler;
    }

    public void handleCreateTourButton() throws IOException {
        viewHandler.openView(Views.CREATETOUR.getFxmlFileName());
    }

}
