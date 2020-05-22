module com.mycompany.projuegorol {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.mycompany.projuegorol to javafx.fxml;
    exports com.mycompany.projuegorol;
}