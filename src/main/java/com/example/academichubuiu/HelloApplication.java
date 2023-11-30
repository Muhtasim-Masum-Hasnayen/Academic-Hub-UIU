package com.example.academichubuiu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Academic Hub UIU");
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setFullScreen(false);
        stage.setResizable(false); // Disable resizing

        stage.show();


        Image uiu = null;
        try {
            uiu = new Image(new FileInputStream("D:\\javaProject\\src\\main\\resources\\com\\example\\academichubuiu\\Icon UIU_Academic_Hub.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        stage.getIcons().add(uiu);
    }
    @Override
    public void stop() throws Exception {
        try {
            TodoData.getInstance().storeTodoItems();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws Exception {
        try {
            TodoData.getInstance().loadTodoItems();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        launch();
    }
}

    
