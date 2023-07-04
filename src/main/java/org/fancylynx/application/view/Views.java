package org.fancylynx.application.view;


// 2do: necessary?? move to constants?
public enum Views {
    HOME("HomeView.fxml"),
    CREATETOUR("TourView.fxml"),
    MAIN("MainView.fxml");


    private final String fxmlFile;

    Views(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

    public String getFxmlFileName() {
        return fxmlFile;
    }
}
