/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package estructuradatos.grupo_04;

import Data.ArbolData;
import TDAs.BinaryTree;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lolaguaman
 */
public class PreguntasYRespuestasController implements Initializable {

    @FXML
    private TextArea preguntas;
    private String controladorRespuestas;
    private int PreguntasUsuario;
    private int PreguntasHechas=0;
    private BinaryTree<String> arbol;
    @FXML
    private Button RespuestaSi;
    @FXML
    private Button RespuestaNo;
    @FXML
    private Button botonFirstTime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preguntas.setText("POR FAVOR PIENSE EN UN ANIMAL");
        CambiarPregunta();
        RespuestaSi.setVisible(false);
        RespuestaNo.setVisible(false);
        RespuestaSi.setDisable(true);
        RespuestaNo.setDisable(true);
    }    

    @FXML
    private void RespuestaSi(ActionEvent event) {
        controladorRespuestas="SI";
        PreguntasHechas++;
    }

    @FXML
    private void RespuestaNo(ActionEvent event) {
        controladorRespuestas="NO";
        PreguntasHechas++;
    }

    @FXML
    private void RegresarPestania(ActionEvent event) {
        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
        //cambiar para que vuelva a la pestania de eliana
        FXMLLoader f = new FXMLLoader(App.class.getResource("/fxml/FileChooser.fxml"));
        Parent root;
            try {
                root = f.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                root.autosize();
            } catch (IOException ex) {
                Logger.getLogger(PreguntasYRespuestasController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void CambiarPregunta(){ 
        //debo descomentar lo de abajo pero necesito el arbol final
        //arbol=FileChooserController.arbolFinal;
        while(PreguntasHechas<=PreguntasUsuario){
            if(ArbolData.esPregunta(arbol.getRootContent())){
                preguntas.setText(arbol.getRootContent());
                if(controladorRespuestas.equals("SI")){
                    arbol=arbol.getLeft();
                    if(arbol==null){
                        System.out.println("Lo sentimos, pero no tenemos un animal que cumpla esa descripcion");
                        break;
                    }
                    if((PreguntasHechas==PreguntasUsuario)&& (arbol!=null)){
                        String respuesta="";
                        for(String respuestas : arbol.listaHojas()){
                            respuesta+=respuestas+", ";
                        }
                        preguntas.setText("Podrias estar pensando en estos animales"+respuesta);
                        break;
                    }
                }else if(controladorRespuestas.equals("NO")){
                    arbol=arbol.getRight();
                    if(arbol==null){
                        System.out.println("Lo sentimos, pero no tenemos un animal que cumpla esa descripcion");
                        break;
                    }
                    if((PreguntasHechas==PreguntasUsuario)&& (arbol!=null)){
                        String respuesta="";
                        for(String respuestas : arbol.listaHojas()){
                            respuesta+=respuestas+", ";
                        }
                        preguntas.setText("Podrias estar pensando en estos animales"+respuesta);
                        break;
                    }
                }
            }else{
                preguntas.setText("Estas pensando en un "+ arbol.getRootContent());
                break;
            }
        }
    }

    @FXML
    private void PensarAnimal(ActionEvent event) {
        botonFirstTime.setVisible(false);
        botonFirstTime.setDisable(true);
        RespuestaSi.setVisible(true);
        RespuestaNo.setVisible(true);
    }

    
}
