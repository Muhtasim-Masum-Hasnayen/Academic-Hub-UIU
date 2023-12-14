package com.example.academichubuiu;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CTMarks implements Initializable {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    public void goTohomepage(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HomePage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private ImageView myImage;
    @FXML
    private ImageView bookImage;
    @FXML
    private ImageView A_Image;
    @FXML
    private ImageView xmImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myImage);
        rotate.setDuration(Duration.millis(6000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.play();

        FadeTransition fade = new FadeTransition();
        fade.setNode(bookImage);
        fade.setDuration(Duration.millis(1000));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(A_Image);
        translate.setDuration(Duration.millis(500));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(-130);
        //translate.setByY(-40);
        translate.setAutoReverse(true);
        translate.play();

        TranslateTransition translat = new TranslateTransition();
        translat.setNode(xmImage);
        translat.setDuration(Duration.millis(500));
        translat.setCycleCount(TranslateTransition.INDEFINITE);
        translat.setByX(40);
        //translat.setByY(-40);
        translat.setAutoReverse(true);
        translat.play();
    }


}
