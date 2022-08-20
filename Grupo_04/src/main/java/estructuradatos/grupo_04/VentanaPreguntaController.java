/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos.grupo_04;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ERWIN AURIA
 */
public class VentanaPreguntaController implements Initializable {

    @FXML
    private Button buttonSi;
    @FXML
    private Button buttonNo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void botonSi(MouseEvent event) throws IOException {
        String msg = "";
        if(!FileChooserController.preguntas.isEmpty()&& !FileChooserController.respuestas.isEmpty()){
            App.setRoot("Ventana Random");  
        }
        if(FileChooserController.preguntas.isEmpty()){
            msg = "No se encontraron preguntas en este archivo";
        }
        if(FileChooserController.respuestas.isEmpty()){
            msg = msg + "Este archivo se encuentra vacio.";
        } 
        Alert alert = new Alert(Alert.AlertType.ERROR, msg + "Vuelva a cargar el(los) archivo(s)");
        alert.show();        
    }
    
    
}
