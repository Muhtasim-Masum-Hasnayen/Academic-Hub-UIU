package com.example.academichubuiu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Server.Server;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the UI
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Academic Hub UIU");

        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setFullScreen(false);
        stage.setResizable(false); // Disable resizing

        // Show the UI
        stage.show();

        // Start the server in a separate thread
        new Thread(() -> {
            Server.netserver();
        }).start();

        // Load the UI icon
        Image uiu = null;
        try {
            uiu = new Image(new FileInputStream("Icon UIU_Academic_Hub.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        stage.getIcons().add(uiu);
    }

    @Override
    public void stop() throws Exception {
        try {
            TodoData.getInstance().storeTodoItems();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws Exception {
        try {
            // Load the ArrayList from the file during application initialization
         Marks.marksarray = (ArrayList<Marks>) loadArrayListFromFile("marksarray.txt");

            TodoData.getInstance().loadTodoItems();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    // Load an ArrayList from a file using object deserialization
    private static List<Marks> loadArrayListFromFile(String filePath) {
        List<Marks> loadedList = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            loadedList = (List<Marks>) inputStream.readObject();
            System.out.println("ArrayList loaded from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            // Log the error message instead of printing the stack trace
            System.err.println("Error loading ArrayList from file: " + e.getMessage());
        }
        return loadedList;
    }


    public static void main(String[] args) {
        launch();
    }
}
