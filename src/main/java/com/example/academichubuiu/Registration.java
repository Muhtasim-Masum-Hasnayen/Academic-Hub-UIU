package com.example.academichubuiu;

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
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;


public class Registration implements Initializable {

    @FXML
    ChoiceBox<String> mybox;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    String[] choice = {"Student", "Faculty"};

    @FXML
    private ImageView myImage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mybox.getItems().addAll(choice);
        mybox.getSelectionModel().selectFirst();

        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myImage);
        rotate.setDuration(Duration.millis(6000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.play();
    }


    @FXML
    public void goTologinpage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginPage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    TextField studentid = new TextField();
    @FXML
    TextField email = new TextField();
    @FXML
    TextField password = new TextField();
    @FXML
    TextField confirmpassword = new TextField();
    @FXML
    TextField name = new TextField();;
    @FXML
    TextField number = new TextField();;



    @FXML
    public void registerStudent() {

        if (mybox.getValue().equals("Student")){
         String studentId = studentid.getText();

        String emailAddress = email.getText();

        String mpassword = password.getText();
        String Name=name.getText();
        String Number=number.getText();

        String confirmPassword = confirmpassword.getText();
        //System.out.println("in rs" + studentId+emailAddress+mpassword);

        if (studentId != null && emailAddress != null && password != null & mpassword.equals(confirmPassword)) {
            //  System.out.println("in if" + studentId+emailAddress+mpassword);
            // Registration successful
            showMessage("Registration successful", "Registration");
            Student s1=new Student(Name,studentId,emailAddress,Number);
            Student.Studentarray.add(s1);
            System.out.println(s1);
            saveStudentData(studentId, emailAddress, mpassword);


            // Save student data to file
            // saveStudentData(studentId, emailAddress, password);
        } else {
            showMessage("Passwords do not match. Registration failed.", "Registration");
        }

    }else{
            String studentId = studentid.getText();
            String emailAddress = email.getText();

            String mpassword = password.getText();

            String confirmPassword = confirmpassword.getText();
            //System.out.println("in rs" + studentId+emailAddress+mpassword);

            if (studentId != null && emailAddress != null && password != null & mpassword.equals(confirmPassword)) {
                //  System.out.println("in if" + studentId+emailAddress+mpassword);
                // Registration successful
                showMessage("Registration successful", "Registration");
                saveFacultyData(studentId, emailAddress, mpassword);


                // Save student data to file
                // saveStudentData(studentId, emailAddress, password);
            } else {
                showMessage("Passwords do not match. Registration failed.", "Registration");
            }




        }




}
    private static void showMessage(String message, String title) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private static void saveStudentData(String studentId, String emailAddress, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("student_data.txt", true))) {
            // Append the student data to the file
            writer.write(studentId+" " +emailAddress+" " +password);
            writer.newLine();
            //System.out.println(studentId+" " +emailAddress+" " +password);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    private static void saveFacultyData(String studentId, String emailAddress, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Faculty_data.txt", true))) {
            // Append the student data to the file
            writer.write(studentId+" " +emailAddress+" " +password);
            writer.newLine();
            //System.out.println(studentId+" " +emailAddress+" " +password);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }



}
