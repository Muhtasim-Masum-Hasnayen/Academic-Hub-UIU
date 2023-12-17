package com.example.academichubuiu;
//package com.example.demo;

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
import java.util.ArrayList;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TCounsellingScedule implements Initializable,Serializable {

    @FXML
    private TableColumn<TableData, String> firstName;

    @FXML
    private TableColumn<TableData, String> lastName;

    @FXML
    private TableColumn<TableData, String> origin;

    @FXML
    private TableView<TableData> table;

    @FXML
    private TextField txtFName;

    @FXML
    private TextField txtLName;

    @FXML
    private TextField txtOrigin;

    ObservableList<TableData> initialData(){
        TableData p1 = new TableData("AOOP","Tuesday"," 8.30 AM");
        TableData p2 = new TableData("Electrical Circuits","Monday"," 11.00-12.20 AM-PM");
        return FXCollections.observableArrayList(p1, p2);
    }

    @FXML
    private void btnInsert(ActionEvent event){

        if(!txtFName.getText().isEmpty() || !txtLName.getText().isEmpty() || !txtOrigin.getText().isEmpty()){
            TableData newData = new TableData(txtFName.getText(), txtLName.getText(), txtOrigin.getText());
            table.getItems().add(newData);
            saveTableDataToFile();
            txtFName.clear();
            txtLName.clear();
            txtOrigin.clear();
        }else{
            System.out.println("Fields should not be empty.");
        }
    }

    @FXML
    private void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<TableData> selectionModel = table.getSelectionModel();
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
        saveTableDataToFile();
    }

    // Method to save the table data to a file
    private void saveTableDataToFile() {
        File file = new File("tabledata.txt");
        ObservableList<TableData> tableDataList = table.getItems();

        // Convert ObservableListWrapper to ArrayList
        ArrayList<TableData> serializableList = new ArrayList<>(tableDataList);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(serializableList);
            System.out.println("Table data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load the table data from a file
    private ObservableList<TableData> loadTableDataFromFile() {
        File file = new File("tabledata.txt");

        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                ArrayList<TableData> data = (ArrayList<TableData>) inputStream.readObject();

                // Convert ArrayList to ObservableList
                ObservableList<TableData> observableList = FXCollections.observableArrayList(data);
                return observableList;
            } catch (EOFException e) {
                // Handle the end of the file
                System.out.println("End of file reached while reading data.");
            } catch (IOException | ClassNotFoundException e) {
                // Handle other exceptions
                e.printStackTrace();
            }
        }
        return FXCollections.observableArrayList();
    }

    @FXML
    private ImageView myImage;
    @FXML
    private ImageView bookImage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstName.setCellValueFactory(new PropertyValueFactory<TableData, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<TableData, String>("lastName"));
        origin.setCellValueFactory(new PropertyValueFactory<TableData, String>("origin"));

        // Load the table data from the file during initialization
        table.setItems(loadTableDataFromFile());

        // Edit data after setting the items
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
    }

    private void editData(){
        firstName.setCellFactory(TextFieldTableCell.<TableData>forTableColumn());
        firstName.setOnEditCommit(event ->{
            TableData tableData = event.getTableView().getItems().get(event.getTablePosition().getRow());
            tableData.setFirstName(event.getNewValue());
            System.out.println(tableData.getLastName() + "'s Name was updated to "+ event.getNewValue() +" at row "+ (event.getTablePosition().getRow() + 1));
        });

        lastName.setCellFactory(TextFieldTableCell.<TableData>forTableColumn());
        lastName.setOnEditCommit(event ->{
            TableData tableData = event.getTableView().getItems().get(event.getTablePosition().getRow());
            tableData.setLastName(event.getNewValue());
            System.out.println(tableData.getFirstName() + "'s Last Name was updated to "+ event.getNewValue() +" at row "+ (event.getTablePosition().getRow() + 1));
        });

        origin.setCellFactory(TextFieldTableCell.<TableData>forTableColumn());
        origin.setOnEditCommit(event ->{
            TableData tableData = event.getTableView().getItems().get(event.getTablePosition().getRow());
            tableData.setOrigin(event.getNewValue());
            System.out.println("Origin was updated to "+ event.getNewValue() +" at row "+ (event.getTablePosition().getRow() + 1));
        });
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
}