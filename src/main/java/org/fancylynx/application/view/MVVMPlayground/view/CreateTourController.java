package org.fancylynx.application.view.MVVMPlayground.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.fancylynx.application.config.Configuration;
import org.fancylynx.application.config.Constants;
import org.fancylynx.application.view.MVVMPlayground.viewmodel.CreateTourViewModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateTourController {
    @FXML
    Button save;
    @FXML
    Button back;
    @FXML
    Button updateImage;
    @FXML
    Button viewConfiguration;
    @FXML
    TextField imageDirectory;
    @FXML
    TextField imageName;
    @FXML
    RadioButton png;
    @FXML
    RadioButton jpg;
    @FXML
    RadioButton jpeg;
    @FXML
    ToggleGroup formatToggleGroup;
    @FXML
    ImageView imageView;

    private CreateTourViewModel viewModel;
    private ViewHandler viewHandler;

    public CreateTourController() {
    }

    public void init(CreateTourViewModel viewModel, ViewHandler viewHandler) throws FileNotFoundException {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;

        formatToggleGroup = new ToggleGroup();
        png.setToggleGroup(formatToggleGroup);
        jpg.setToggleGroup(formatToggleGroup);
        jpeg.setToggleGroup(formatToggleGroup);
        png.setSelected(true);
        imageName.setText(Constants.DEFAULT_IMAGE_NAME);
        imageDirectory.setText(Constants.DEFAULT_IMAGE_SAVE_DIRECTORY);

//        Image image = new Image("file:///images/tourImage.png");// + Configuration.getImageDirectory() + "tourImage.png");//Configuration.getImageName() + "." + Configuration.getImageFormat());
//        imageView.setImage(image);
        Image image = new Image(new FileInputStream("images/tourImage.png"));
        imageView.setImage(image);

//        imageView.setImage(new Image("file:///images/tourImage.png"));
    }

    @FXML
    public void handleBackButton() throws IOException {
        viewHandler.openView(View.HOME.getFxmlFile());
    }

    @FXML
    public void handleSaveButton() throws IOException {
        System.out.println("saving");
        RadioButton selectedRadioButton = (RadioButton) formatToggleGroup.getSelectedToggle();
        Configuration.setImageFormat(selectedRadioButton.getText());
        Configuration.setImageName(imageName.getText());
        Configuration.setImageDirectory(imageDirectory.getText());
    }

    @FXML
    private void handleViewConfigurationButton() {
        System.out.println(Configuration.getImageDirectory());
        System.out.println(Configuration.getImageName());
        System.out.println(Configuration.getImageFormat());
    }

    @FXML
    private void handleUpdateImageButton() throws FileNotFoundException {
        System.out.println("updating image");
        Image image = new Image(new FileInputStream("images/tourImage_3.png"));
        imageView.setImage(image);
    }
}