package com.example.academichubuiu;

//package com.example.demo;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Person {
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
    public static ObservableList<Person> getInitialList() {
        Person p1 = new Person("Chris", "James", "US");
        Person p2 = new Person("James", "Brown", "US");
        Person p3 = new Person("Jake", "Buck", "US");
        Person p4 = new Person("Blake", "David", "US");
        return FXCollections.observableArrayList(p1, p2, p3, p4);
    }

    public static TableColumn<Person, String> getFistNameCol(){
        TableColumn<Person, String> fNameCol = new TableColumn<>("First Name");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        return fNameCol;
    }

    public static TableColumn<Person, String> getLastNameCol(){
        TableColumn<Person, String> lNameCol = new TableColumn<>("Last Name");
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        return lNameCol;
    }

    public static TableColumn<Person, String> getOriginCol(){
        TableColumn<Person, String> originCol = new TableColumn<>("Origin");
        originCol.setCellValueFactory(new PropertyValueFactory<>("origin"));
        return originCol;
    }

    // end of the code without using an FXML file

    public Person(String firstName, String lastName, String origin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.origin = origin;
    }
}