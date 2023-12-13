package com.example.academichubuiu;


import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.text.DecimalFormat;

import java.io.IOException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
        @FXML
        private AnchorPane stage1;
        @FXML
        private TextField t;
        @FXML
        private AnchorPane anchor_detail;
        @FXML
        private Label label;
        @FXML
        private Label cgpaMeter;
        @FXML
        private Button refresh;


        public Button submit = new Button("Submit");


        public void exitbutton() {
            System.exit(0);
        }

        public void currentCGPA() {
            anchor_detail.getChildren().clear();

            final int[] y = {0};
            TextField t = new TextField();
            t.setPromptText("Enter the no. of course");
            Button b = new Button("Enter");

        /*VBox v = new VBox(10);

        ListView l = new ListView();


       v.getChildren().addAll(t, b, l);
        v.setAlignment(Pos.TOP_CENTER);*/
            ;

            Label[] labelArray = new Label[100];
            TextField[] textFieldArray = new TextField[100];
            TextField[] textFieldArray2 = new TextField[100];

            VBox vb = new VBox(t, b);
            vb.setAlignment(Pos.CENTER);
            HBox[] hb = new HBox[100];


            b.setOnAction(event -> {

                label.setVisible(false);
                String x = t.getText();
                System.out.println(x);
                y[0] = Integer.parseInt(x);

                if (y[0] > 10) {

                    label.setVisible(true);
                    return;

                }

                for (int j = 0; j < y[0]; j++) {
                    int flag = j + 1;
                    hb[j] = new HBox(50);

                    // buttonArray[j] = new Button("Course : "+flag);
                    labelArray[0] = new Label("Course : " + flag);
                    labelArray[0].setFont(Font.font(20));
                    labelArray[0].setTextFill(new Color(0.9804, 0.9529, 1, 1));

                    textFieldArray[j] = new TextField();
                    textFieldArray[j].setPromptText("Enter the GPA");

                    textFieldArray2[j] = new TextField();
                    textFieldArray2[j].setPromptText("Enter the Credit");


                    hb[j].getChildren().addAll(labelArray[0], textFieldArray[j], textFieldArray2[j]);


                }
                for (int i = 0; i < y[0]; i++) {
                    vb.getChildren().add(hb[i]);
                }

                submit.setAlignment(Pos.CENTER);
                vb.getChildren().addAll(submit);

                submit.setOnAction(event1 -> {
                    String temp;
                    double storage = 0.00, gpa, cgpa, credit, totalCredit = 0.00;
                    for (int i = 0; i < y[0]; i++) {
                        temp = textFieldArray[i].getText();
                        gpa = Double.parseDouble(temp);
                        temp = textFieldArray2[i].getText();
                        credit = Double.parseDouble(temp);

                        storage += (gpa * credit);
                        totalCredit += credit;

                    }

                    cgpa = storage / totalCredit;
                    DecimalFormat f = new DecimalFormat("#.##");
                    //f.format(cgpa);

                    Label resultLabel = new Label("CGPA : "+ f.format(cgpa));
                    resultLabel.setFont(Font.font(26));
                    resultLabel.setTextFill(new Color(0.9804, 0.9529, 1, 1));

                    vb.getChildren().add(resultLabel);


                });


            });


            anchor_detail.getChildren().addAll(vb);


        }
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

        public void setRefresh() {
            anchor_detail.getChildren().clear();
        }

        public void setTotalCGPA() {

            anchor_detail.getChildren().clear();
            Label l1 = new Label("CGPA till Last Semester");
            l1.setFont(Font.font(20));
            l1.setTextFill(new Color(0.9804, 0.9529, 1, 1));

            TextField t1 = new TextField();
            t1.setPromptText("Enter Last CGPA");

            Label l = new Label("Credit Completed ?");
            l.setFont(Font.font(20));
            l.setTextFill(new Color(0.9804, 0.9529, 1, 1));

            TextField t = new TextField();
            t.setPromptText("Credit Completed");

            Label l2 = new Label("Current Semester CGPA");
            l2.setFont(Font.font(20));
            l2.setTextFill(new Color(0.9804, 0.9529, 1, 1));

            TextField t2 = new TextField();
            t2.setPromptText("Current Semester CGPA");

            Label l3 = new Label("Current Semester completed credit");
            l3.setFont(Font.font(20));
            l3.setTextFill(new Color(0.9804, 0.9529, 1, 1));

            TextField t3 = new TextField();
            t3.setPromptText("Current Semester completed credit");

            Button submit = new Button("Submit");


            VBox vBox = new VBox(10);
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(l1, t1, l, t, l2, t2, l3, t3, submit);

            submit.setOnAction(event -> {
                String temp;
                double lastCG, lastCredit, presentCG, presentCredit;
                temp = t1.getText();
                lastCG = Double.parseDouble(temp);
                temp = t.getText();
                lastCredit = Double.parseDouble(temp);
                temp = t2.getText();
                presentCG = Double.parseDouble(temp);
                temp = t3.getText();
                presentCredit = Double.parseDouble(temp);

                double result1 = (lastCG * lastCredit) + (presentCG * presentCredit);
                double result2 = lastCredit + presentCredit;
                double result = result1 / result2;

                Label resultLabel = new Label("Your CGPA is " + result);
                resultLabel.setFont(Font.font(40));
                resultLabel.setTextFill(new Color(0.9804, 0.9529, 1, 1));

                vBox.getChildren().add(resultLabel);
            });

            anchor_detail.getChildren().add(vBox);


        }


    @FXML
    private ImageView myImage;
    @FXML
    private ImageView bookImage;

    @FXML
    private ImageView lightImage;
    @FXML
    private ImageView calImage;

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

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(lightImage);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(50);
        translate.setByY(-40);
        translate.setAutoReverse(true);
        translate.play();

        /*FadeTransition fade1 = new FadeTransition();
        fade1.setNode(calImage);
        fade1.setDuration(Duration.millis(500));
        fade1.setCycleCount(TranslateTransition.INDEFINITE);
        fade1.setInterpolator(Interpolator.LINEAR);
        fade1.setFromValue(0);
        fade1.setToValue(1);
        fade1.play();*/
    }


    }


