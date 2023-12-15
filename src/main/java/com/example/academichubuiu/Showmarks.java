package com.example.academichubuiu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Showmarks {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
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


    public void showmark() {
       // System.out.println("Clicked");

        //System.out.println(Marks.marksarray);

        String course = coursecode.getText();
        System.out.println("course code:"+course);
        boolean check=false;
        System.out.println(Marks.marksarray);
        for (int i = 0; i < Marks.marksarray.size(); i++){

            if (course.equalsIgnoreCase(Marks.marksarray.get(i).getCoursecode()))  {
               check=true;
                ct1.setText(Marks.marksarray.get(i).getCt1());
                ct2.setText(Marks.marksarray.get(i).getCt2());
                ct3.setText(Marks.marksarray.get(i).getCt3());
                ct4.setText(Marks.marksarray.get(i).getCt4());
                assignment1.setText(Marks.marksarray.get(i).getAssignment1());
                assignment2.setText(Marks.marksarray.get(i).getAssignment2());
                mid.setText(Marks.marksarray.get(i).getMid());
                Final.setText(Marks.marksarray.get(i).getFinal());

            }
            else{


                studentid.clear();
                ct1.clear();
                ct2.clear();
                ct3.clear();
                ct4.clear();
                assignment1.clear();
                assignment2.clear();
                mid.clear();
                Final.clear();
            }
            }if(check==false){ LoginPage.showMessage("Invalid CourseCode","Academic Hub UIU"); }
    }










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
}
