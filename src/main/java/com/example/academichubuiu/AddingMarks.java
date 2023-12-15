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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddingMarks implements Initializable , Serializable {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    public void CT(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Showmarks.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void AssignmentsMarks(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AssignmentsMarks.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    TextField coursecode=new TextField();
    @FXML
    TextField studentid=new TextField();

    @FXML
    TextField ct1=new TextField();
    @FXML
    TextField ct2=new TextField();
    @FXML
    TextField ct3=new TextField();
    @FXML
    TextField ct4=new TextField();
    @FXML
    TextField assignment1=new TextField();
    @FXML
    TextField assignment2=new TextField();
    @FXML
    TextField mid=new TextField();
    @FXML
    TextField Final=new TextField();
    @FXML
    public void markinputs(){

        Marks mark=new Marks(coursecode.getText(),studentid.getText(),ct1.getText(),
                ct2.getText(),ct3.getText(),ct4.getText(),
               assignment1.getText(),assignment2.getText(),mid.getText(),
                Final.getText());


Marks.marksarray.add(mark);

LoginPage.showMessage("Marks Successfully Added","Marks Adding Information");

        coursecode.clear();
        studentid.clear();
        ct1.clear();
        ct2.clear();
        ct3.clear();
        ct4.clear();
        assignment1.clear();
        assignment2.clear();
        mid.clear();
        Final.clear();
try {
    File file = new File("marksarray.txt");


    saveArrayListToFile(Marks.marksarray, "marksarray.txt");


}catch(Exception e){ System.out.println("Finded");}



    }


    private static void saveArrayListToFile(ArrayList<Marks> list, String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(list);
            System.out.println("ArrayList saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving ArrayList to file: " + e.getMessage());
            e.printStackTrace();
        }
    }















    @FXML
    private ImageView myImage;
    @FXML
    private ImageView bookImage;

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
        fade.setDuration(Duration.millis(5000));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }


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
