/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos.grupo_04;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ERWIN AURIA
 */
public class VentanaRandomController implements Initializable {

    @FXML
    private TextField lblMaximo;
    public static int nMaximo;
    @FXML
    private Label lblAnimal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> preguntas = FileChooserController.preguntas;
        int nMaximo = Integer.parseInt(lblMaximo.getText());
        
        if(nMaximo > preguntas.size()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "El numero que ingreso esta fuera del limite");
            alert.show();
        }
         
        lblAnimal.setVisible(false);
    }    
    
    
    
}
