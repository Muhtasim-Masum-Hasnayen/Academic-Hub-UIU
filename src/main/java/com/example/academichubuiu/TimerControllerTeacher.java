package com.example.academichubuiu;

import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TimerControllerTeacher implements Initializable {

    @FXML
    Label lblTimer;

    @FXML
    ImageView btnStart, btnStop, btnPause, btnLap;

    @FXML
    ProgressBar progress;

    @FXML
    ListView<TimerLap> lapsData;

    @FXML
    AnchorPane header;

    Timeline timeline;

    LocalTime time = LocalTime.parse("00:00:00");
    LocalTime tempTime = LocalTime.parse("00:00:00");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    int lapsCounter;
    ObservableList<TimerLap> laps = FXCollections.observableArrayList();

    @FXML
    private ImageView myImage;
    @FXML
    private ImageView bookImage;
    @FXML
    private ImageView clockImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> incrementTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
        progress.setProgress(0);
        //enableDisableControls(true, btnPause);
        lapsData.setCellFactory(listView -> new ListCell<TimerLap>() {
            @Override
            protected void updateItem(TimerLap lap, boolean empty) {
                super.updateItem(lap, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    // Create a HBox to hold our displayed value
                    HBox hBox = new HBox(5);
                    //hBox.setAlignment(Pos.CENTER);
                    hBox.setSpacing(15);
                    // Add the values from our piece to the HBox
                    hBox.getChildren().addAll(
                            lap.getImageView(),
                            new Label(lap.getLap())
                    );
                    // Set the HBox as the display
                    setGraphic(hBox);



    }
}
        });


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
        fade.setDuration(Duration.millis(5000));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

        RotateTransition rotate2 = new RotateTransition();
        rotate2.setNode(clockImage);
        rotate2.setDuration(Duration.millis(4000));
        rotate2.setCycleCount(TranslateTransition.INDEFINITE);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setByAngle(360);
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.play();

    }
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    public void gotohomepage(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("teacher.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    private void startTimer() {


//        enableDisableControls(true, btnLap);
//        enableDisableControls(true, btnStart);
//        enableDisableControls(false, btnPause);
        timeline.play();
       // progress.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
    }

    @FXML
    private void pauseTimer(MouseEvent event) {
        progress.setProgress(0);
//        enableDisableControls(true, btnLap);
//        enableDisableControls(false, btnStart);
        if (timeline.getStatus().equals(Animation.Status.PAUSED)) {
            timeline.play();
        } else if (timeline.getStatus().equals(Animation.Status.RUNNING)) {
            timeline.pause();
        }
    }

    @FXML
    private void endTimer(MouseEvent mouseEvent) {
//        enableDisableControls(true, btnLap);
//        enableDisableControls(false, btnStart);
//        enableDisableControls(true, btnPause);
        lapsCounter = 0;
        lapsData.getItems().clear();
        progress.setProgress(0);
        timeline.stop();
        time = LocalTime.parse("00:00:00");
        lblTimer.setText(time.format(dtf));
    }

    private void incrementTime() {
        time = time.plusSeconds(1);
        lblTimer.setText(time.format(dtf));
    }

    @FXML
    private void addLaps(MouseEvent mouseEvent) {
        lapsCounter += 1;
        tempTime = tempTime.plusHours(time.getHour()).plusMinutes(time.getMinute()).plusSeconds(time.getSecond());
        ImageView imageView = new ImageView();
        //System.out.println("PATH ->" + System.getProperty("user.dir") + "\\src\\Sample\\grayFlag.png");
        imageView.setImage(new Image(new File(System.getProperty("user.dir") + "\\src\\Sample\\grayFlag.png").toURI().toString()));
        imageView.setFitWidth(25);
        imageView.setFitHeight(25);

        laps.add(new TimerLap(imageView, new String(lapsCounter + "          " + "+ " + time + "         " + tempTime)));
        lapsData.setItems(laps);
    }

    public void enableDisableControls(boolean disable, ImageView imageView) {
        if (disable) {
            if (imageView.equals(btnLap)) {
                btnLap.setDisable(true);
                btnLap.setImage(new Image(new File(System.getProperty("user.dir") + "grayFlag.png").toURI().toString()));
            } else if (imageView.equals(btnStart)) {
                btnStart.setDisable(true);
                btnStart.setImage(new Image(new File(System.getProperty("user.dir") + "grayPlay.png").toURI().toString()));
            } else if (imageView.equals(btnPause)) {
                btnPause.setDisable(true);
                btnPause.setImage(new Image(new File(System.getProperty("user.dir") + "grayPause.png").toURI().toString()));
            }

        } else {
            if (imageView.equals(btnLap)) {
                btnLap.setDisable(false);
                btnLap.setImage(new Image(new File(System.getProperty("user.dir") + "flag.png").toURI().toString()));
            } else if (imageView.equals(btnStart)) {
                btnStart.setDisable(false);
                btnStart.setImage(new Image(new File(System.getProperty("user.dir") + "play.png").toURI().toString()));
            } else if (imageView.equals(btnPause)) {
                btnPause.setDisable(false);
                btnPause.setImage(new Image(new File(System.getProperty("user.dir") + "pause.png").toURI().toString()));
            }
        }
    }

}
