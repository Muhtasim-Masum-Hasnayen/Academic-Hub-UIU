package com.example.academichubuiu;
//package com.example.demo;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    private TableColumn<Person, String> firstName;

    @FXML
    private TableColumn<Person, String> lastName;

    @FXML
    private TableColumn<Person, String> origin;

    @FXML
    private TableView<Person> table;

    @FXML
    private TextField txtFName;

    @FXML
    private TextField txtLName;

    @FXML
    private TextField txtOrigin;

    ObservableList<Person> initialData(){
        Person p1 = new Person("AOOP","Tuesday"," 8.30 AM");
        Person p2 = new Person("Electrical Circuits","Monday"," 11.00-12.20 AM-PM");
        return FXCollections.observableArrayList(p1, p2);
    }

    @FXML
    private void btnInsert(ActionEvent event){

        if(!txtFName.getText().isEmpty() || !txtLName.getText().isEmpty() || !txtOrigin.getText().isEmpty()){
            Person newData = new Person(txtFName.getText(), txtLName.getText(), txtOrigin.getText());
            table.getItems().add(newData);
            txtFName.clear();
            txtLName.clear();
            txtOrigin.clear();
        }else{
            System.out.println("Fields should not be empty.");
        }
    }

    @FXML
    private void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Person> selectionModel = table.getSelectionModel();
        if(selectionModel.isEmpty()){
            System.out.println("You need select a data before deleting.");
        }

        ObservableList<Integer> list = selectionModel.getSelectedIndices();
        Integer[] selectedIndices = new Integer[list.size()];
        selectedIndices = list.toArray(selectedIndices);

        Arrays.sort(selectedIndices);

        for(int i = selectedIndices.length - 1; i >= 0; i--){
            selectionModel.clearSelection(selectedIndices[i].intValue());
            table.getItems().remove(selectedIndices[i].intValue());
        }
    }

    @FXML
    private ImageView myImage;
    @FXML
    private ImageView bookImage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        origin.setCellValueFactory(new PropertyValueFactory<Person, String>("origin"));

        table.setItems(initialData());

        editData();


        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myImage);
        rotate.setDuration(Duration.millis(6000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.play();

        RotateTransition rotate2 = new RotateTransition();
        rotate2.setNode(bookImage);
        rotate2.setDuration(Duration.millis(4000));
        rotate2.setCycleCount(TranslateTransition.INDEFINITE);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setByAngle(360);
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.play();

        /*FadeTransition fade = new FadeTransition();
        fade.setNode(bookImage);
        fade.setDuration(Duration.millis(5000));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();*/
    }

    private void editData(){
        firstName.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        firstName.setOnEditCommit(event ->{
            Person person = event.getTableView().getItems().get(event.getTablePosition().getRow());
            person.setFirstName(event.getNewValue());
            System.out.println(person.getLastName() + "'s Name was updated to "+ event.getNewValue() +" at row "+ (event.getTablePosition().getRow() + 1));
        });

        lastName.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        lastName.setOnEditCommit(event ->{
            Person person = event.getTableView().getItems().get(event.getTablePosition().getRow());
            person.setLastName(event.getNewValue());
            System.out.println(person.getFirstName() + "'s Last Name was updated to "+ event.getNewValue() +" at row "+ (event.getTablePosition().getRow() + 1));
        });

        origin.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        origin.setOnEditCommit(event ->{
            Person person = event.getTableView().getItems().get(event.getTablePosition().getRow());
            person.setOrigin(event.getNewValue());
            System.out.println("Origin was updated to "+ event.getNewValue() +" at row "+ (event.getTablePosition().getRow() + 1));
        });
    }

    /*@FXML
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
    }*/
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    public void gotohomepage(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HomePage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}