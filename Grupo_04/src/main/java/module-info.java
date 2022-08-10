module estructuradatos.grupo_04 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens estructuradatos.grupo_04 to javafx.fxml;
    exports estructuradatos.grupo_04;
}
