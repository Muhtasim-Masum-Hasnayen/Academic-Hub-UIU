module com.example.academichubuiu {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.academichubuiu to javafx.fxml;
    exports com.example.academichubuiu;
}