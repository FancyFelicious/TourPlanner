package org.fancylynx.application.view.MVVMPlayground.view;

public enum View {
    HOME("HomeView.fxml"),
    CREATETOUR("CreateTourView.fxml");


    private final String fxmlFile;

    View(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

    public String getFxmlFile() {
        return fxmlFile;
    }
}
