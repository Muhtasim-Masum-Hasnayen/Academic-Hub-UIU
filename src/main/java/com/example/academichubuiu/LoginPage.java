package com.example.academichubuiu;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;

import java.io.IOException;
public class LoginPage implements Initializable {
    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;
    @FXML
    private Button play;

    @FXML
    ChoiceBox<String> mybox;
    private String[] choice = {"Student", "Faculty"};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        play(null);
        mybox.getItems().addAll(choice);
        mybox.getSelectionModel().selectFirst();
    }


    @FXML
    private void setRotate(Circle c, boolean reverse, int angle, int duration) {
        RotateTransition rt = new RotateTransition(Duration.seconds(duration), c);
        rt.setAutoReverse(reverse);
        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(100);
        rt.play();
    }

    @FXML
    private void play(ActionEvent actionEvent) {
        setRotate(c1, true, 360, 12);
        setRotate(c2, true, 220, 15);
        setRotate(c3, true, 145, 20);

    }

    @FXML
    private static Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void goToRegistrationPage(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Registration.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void goToForgetPassPage(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ForgetPassword.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void goToHomePage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HomePage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    TextField studentid = new TextField();
    @FXML
    TextField password = new TextField();

    @FXML
    public void loginStudent(ActionEvent event) {

        if (mybox.getValue().equals("Student")){
            String mstudentId = studentid.getText();
        String mpassword = password.getText();

        boolean loginSuccessful = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("student_data.txt"))) {
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String studentId = parts[0];
                String emailAddress = parts[1];
                String password = parts[2];

                // Check if provided credentials match any record in the file
                if (mstudentId.equals(studentId) && mpassword.equals(password)) {
                    loginSuccessful = true;
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        if (loginSuccessful) {
            try {
                goToHomePage(event);
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception according to your needs
            }
        } else {
            showMessage("Invalid Information. Login failed.", "Login");
        }
    }
        else{
            String mstudentId = studentid.getText();
            String mpassword = password.getText();

            boolean loginSuccessful = false;

            try (BufferedReader reader = new BufferedReader(new FileReader("Faculty_data.txt"))) {
                String line;

                // Read each line from the file
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    String studentId = parts[0];
                    String emailAddress = parts[1];
                    String password = parts[2];

                    // Check if provided credentials match any record in the file
                    if (mstudentId.equals(studentId) && mpassword.equals(password)) {
                        loginSuccessful = true;
                        break;
                    }
                }

            } catch (IOException e) {
                System.err.println("Error reading from file: " + e.getMessage());
            }

            if (loginSuccessful) {
                try {
                    goToTeacherPage(event);
                } catch (IOException e) {
                    e.printStackTrace(); // Handle the exception according to your needs
                }
            } else {
                showMessage("Invalid Faculty Information. Login failed.", "Login");
            }



        }


}
    public void goToTeacherPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("teacher.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public static void showMessage(String message, String title) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();


    }





}