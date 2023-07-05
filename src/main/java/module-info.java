module com.example.timerrecovery {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.timerrecovery to javafx.fxml;
    exports com.example.timerrecovery;
}