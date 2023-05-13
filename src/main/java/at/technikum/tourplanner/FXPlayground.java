package at.technikum.tourplanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXPlayground extends Application {
    private int count = 0;
    private Text countText;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        countText = new Text("Count: " + count);
        countText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        countText.setFill(Color.LIGHTGREEN);

        Button incrementButton = new Button("Increment");
        incrementButton.setOnAction(event -> {
            count++;
            countText.setText("Count: " + count);
        });

        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: #22313F");
        layout.getChildren().addAll(countText, incrementButton);
        StackPane root = new StackPane(layout);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

