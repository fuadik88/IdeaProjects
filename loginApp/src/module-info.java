module loginApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.base;
    requires java.logging;
    requires javafx.base;
    requires javafx.baseEmpty;

    opens login;
    exports login;
}