package org.fancylynx.application.view;

public enum Views {
    HOME("HomeView.fxml"),
    CREATETOUR("CreateTourView.fxml");


    private final String fxmlFile;

    Views(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

    public String getFxmlFileName() {
        return fxmlFile;
    }
}