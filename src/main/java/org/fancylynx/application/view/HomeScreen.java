//package org.fancylynx.application.view;
//
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class HomeScreen extends Application {
//    private Stage primaryStage;
//    private StackPane rootPane;
//    private VBox homeLayout;
//    private VBox configLayout;
//    private VBox testAreaLayout;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        this.primaryStage = primaryStage;
//
//        // Create the buttons
//        Button editConfigButton = new Button("Edit Configuration");
//        Button testAreaButton = new Button("TestArea");
//
//        // Set the actions for the buttons
//        editConfigButton.setOnAction(event -> showConfigScreen());
//        testAreaButton.setOnAction(event -> showTestAreaScreen());
//
//        // Create the layout for the home screen
//        homeLayout = new VBox(10);
//        homeLayout.setAlignment(Pos.CENTER);
//        homeLayout.getChildren().addAll(editConfigButton, testAreaButton);
//
//        // Create the layout for the configuration screen
//        configLayout = new VBox(10);
//        configLayout.setAlignment(Pos.CENTER);
//        configLayout.getChildren().addAll(createConfigComponents(), createBackButton());
//
//        // Create the layout for the test area screen
//        testAreaLayout = new VBox(10);
//        testAreaLayout.setAlignment(Pos.CENTER);
//        testAreaLayout.getChildren().addAll(createTestAreaComponents(), createBackButton());
//
//        // Create the root pane
//        rootPane = new StackPane(homeLayout);
//
//        // Create the scene and set it to the stage
//        Scene scene = new Scene(rootPane, 800, 600);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Home Screen");
//        primaryStage.show();
//    }
//
//    private void showConfigScreen() {
//        rootPane.getChildren().setAll(configLayout);
//    }
//
//    private void showTestAreaScreen() {
//        rootPane.getChildren().setAll(testAreaLayout);
//    }
//
//    private VBox createConfigComponents() {
//        // Create the UI components for the configuration screen
//        // ...
//        Label directoryLabel = new Label("Default Directory:");
//        TextField directoryField = new TextField();
//        Button directoryButton = new Button("Set directory");
//
//        Label nameLabel = new Label("Default Name:");
//        TextField nameField = new TextField();
//        Button nameButton = new Button("Set name");
//
//        RadioButton pngRadioButton = new RadioButton(".png");
//        RadioButton jpgRadioButton = new RadioButton(".jpg");
//        RadioButton jpegRadioButton = new RadioButton(".jpeg");
//
//        // ...
//
//        // Create the layout for the configuration screen
//        VBox layout = new VBox(10);
//        layout.setAlignment(Pos.CENTER);
//        layout.getChildren().addAll(
//                directoryLabel, directoryField, directoryButton,
//                nameLabel, nameField, nameButton,
//                pngRadioButton, jpgRadioButton, jpegRadioButton
//        );
//
//        return layout;
//    }
//
//    private VBox createTestAreaComponents() {
//        // Create the UI components for the test area screen
//        // ...
//        Button backButton = new Button("Back");
//
//        // ...
//
//        // Set the action for the back button
//        backButton.setOnAction(event -> rootPane.getChildren().setAll(homeLayout));
//
//        // Create the layout for the test area screen
//        VBox layout = new VBox(10);
//        layout.setAlignment(Pos.CENTER);
////        layout.getChildren().addAll(backButton);
//
//        return layout;
//    }
//
//    private Button createBackButton() {
//        // Create the back button with the same functionality as on the test area screen
//        Button backButton = new Button("Back");
//        backButton.setOnAction(event -> rootPane.getChildren().setAll(homeLayout));
//        return backButton;
//    }
//}
//
//
////import javafx.application.Application;
////import javafx.scene.Scene;
////import javafx.scene.control.Button;
////import javafx.scene.layout.StackPane;
////import javafx.stage.Stage;
////
////public class HomeScreen extends Application {
////    public static void main(String[] args) {
////        launch(args);
////    }
////
////    @Override
////    public void start(Stage primaryStage) {
////        // Create the buttons
////        Button editConfigButton = new Button("Edit Configuration");
////        Button testAreaButton = new Button("TestArea");
////
////        // Set the actions for the buttons
////        editConfigButton.setOnAction(event -> {
////            SetValuesFXPlayground setValuesFXPlayground = new SetValuesFXPlayground();
////            setValuesFXPlayground.start(new Stage());
////        });
////
////        testAreaButton.setOnAction(event -> {
////            Stage testAreaStage = new Stage();
////            Button backButton = new Button("Back");
////
////            // Set the action for the back button
////            backButton.setOnAction(backEvent -> primaryStage.show());
////
////            // Create the layout for the test area screen
////            StackPane testAreaLayout = new StackPane();
////            testAreaLayout.setStyle("-fx-background-color: blue;");
////            testAreaLayout.getChildren().add(backButton);
////
////            // Create the scene and set it to the stage
////            Scene testAreaScene = new Scene(testAreaLayout, 800, 600);
////            testAreaStage.setScene(testAreaScene);
////            testAreaStage.setTitle("Test Area");
////            testAreaStage.show();
////        });
////
////        // Create the layout for the home screen
////        StackPane homeLayout = new StackPane();
////        homeLayout.getChildren().addAll(editConfigButton, testAreaButton);
////
////        // Create the scene and set it to the stage
////        Scene homeScene = new Scene(homeLayout, 800, 600);
////        primaryStage.setScene(homeScene);
////        primaryStage.setTitle("Home Screen");
////        primaryStage.show();
////    }
////}
