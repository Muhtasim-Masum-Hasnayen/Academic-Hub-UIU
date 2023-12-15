package com.example.academichubuiu;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentProgress implements Initializable {

    @FXML
    private PieChart ChartPie;

    @FXML
    private Button btnAdd;

    @FXML
    private TextArea taChartDataDisplay;

    @FXML
    private TextField txtmarks;

    @FXML
    private TextField txtname;

    public StudentProgress() {
    }

    @FXML
    void OnAdd(ActionEvent event) {

        String name = txtname.getText();
        double marks = new Integer(txtmarks.getText()).doubleValue();

        PieChart.Data data = new PieChart.Data(name,marks);
        ChartData.add(data);
        ChartPie.setData(ChartData);

        taChartDataDisplay.appendText("Name: "+name+"\nMarks: "+txtmarks.getText()+"\n");



    }

    @FXML
    private ImageView myImage;
    @FXML
    private ImageView bookImage;

    ObservableList<PieChart.Data> ChartData = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChartData = FXCollections.observableArrayList();
        ChartPie.setTitle("Student Progress");


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
    }




    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;


    public void gotoThome(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("teacher.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}