package estructuradatos.grupo_04;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    private Label lbPreguntastxt;
    @FXML
    private Label lbRespuestastxt;
    @FXML
    private Button btnCargarPreguntas;
    @FXML
    private Button btnCargarRespuestas;
    @FXML
    private Button primaryButton;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void fileChooserPreguntas(ActionEvent event) {
    }

    @FXML
    private void fileChooserRespuestas(ActionEvent event) {
    }
}
