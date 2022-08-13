package estructuradatos.grupo_04;

import TDAs.BinaryTree;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    
    public static BinaryTree<String> arbolFinal;
    public static boolean filePredeterminado=true;

    public void initialize(URL url, ResourceBundle rb) {
        if(filePredeterminado){
        lbPreguntastxt.setText("preguntas.txt");
        lbRespuestastxt.setText("preguntas.txt");
        }else{
            lbPreguntastxt.setText(FileChooserController.nomPreguntas);
            lbRespuestastxt.setText(FileChooserController.nomRespuestas);
        }
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void fileChooserPreguntas(ActionEvent event) throws IOException {
        App.setRoot("FileChooser");
    }

    @FXML
    private void fileChooserRespuestas(ActionEvent event) {
    }
}
