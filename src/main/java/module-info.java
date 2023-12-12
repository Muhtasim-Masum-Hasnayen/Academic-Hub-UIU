module com.example.academichubuiu {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;
    requires javafx.swing;

    opens com.example.academichubuiu to javafx.fxml;
    exports com.example.academichubuiu;
}