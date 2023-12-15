package com.example.academichubuiu;

//package com.example.demo;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Serializable;

public class TableData implements Serializable {
    private String firstName;
    private String lastName;
    private String origin;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOrigin() {
        return origin;
    }

    // this code is for retrieving any data without using the FXML
    public static ObservableList<TableData> getInitialList() {
        TableData p1 = new TableData("Chris", "James", "US");
        TableData p2 = new TableData("James", "Brown", "US");
        TableData p3 = new TableData("Jake", "Buck", "US");
        TableData p4 = new TableData("Blake", "David", "US");
        return FXCollections.observableArrayList(p1, p2, p3, p4);
    }

    public static TableColumn<TableData, String> getFistNameCol(){
        TableColumn<TableData, String> fNameCol = new TableColumn<>("First Name");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        return fNameCol;
    }

    public static TableColumn<TableData, String> getLastNameCol(){
        TableColumn<TableData, String> lNameCol = new TableColumn<>("Last Name");
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        return lNameCol;
    }

    public static TableColumn<TableData, String> getOriginCol(){
        TableColumn<TableData, String> originCol = new TableColumn<>("Origin");
        originCol.setCellValueFactory(new PropertyValueFactory<>("origin"));
        return originCol;
    }

    // end of the code without using an FXML file

    public TableData(String firstName, String lastName, String origin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.origin = origin;
    }
}