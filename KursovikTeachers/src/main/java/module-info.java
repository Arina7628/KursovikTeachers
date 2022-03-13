module com.example.readerexcel {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.apache.poi.poi;
    requires java.desktop;

    opens com.example.KursovikTeachers to javafx.fxml;
    exports com.example.KursovikTeachers;
}