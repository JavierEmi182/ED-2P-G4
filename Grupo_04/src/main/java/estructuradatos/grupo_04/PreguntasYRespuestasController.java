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
 * @author jeremy
 */
public class PreguntasYRespuestasController implements Initializable {

    @FXML
    private TextArea preguntas;
    private BinaryTree<String> arbol = PrimaryController.arbolFinal;
    private int PreguntasHechas = 0;
    private int PreguntasUsuario = VentanaRandomController.nMaximo;
    @FXML
    private Button RespuestaSi;
    @FXML
    private Button RespuestaNo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(PreguntasUsuario);
        if (PreguntasHechas != PreguntasUsuario) {
            preguntar();
        } else {
            preguntas.setText("No puedo adivinar el animal.");
            RespuestaSi.setVisible(false);
            RespuestaSi.setDisable(true);
            RespuestaNo.setVisible(false);
            RespuestaNo.setDisable(true);
        }

    }

    @FXML
    private void RespuestaSi(ActionEvent event) {
        respuestaSi();
        if (PreguntasHechas != PreguntasUsuario) {
            preguntar();
        } else {
            darRespuesta(this.arbol);
            RespuestaSi.setVisible(false);
            RespuestaSi.setDisable(true);
            RespuestaNo.setVisible(false);
            RespuestaNo.setDisable(true);
        }
    }

    @FXML
    private void RespuestaNo(ActionEvent event) {
        respuestaNo();
        if (PreguntasHechas != PreguntasUsuario) {
            preguntar();
        } else {
            darRespuesta(this.arbol);
            RespuestaNo.setVisible(false);
            RespuestaNo.setDisable(true);
            RespuestaSi.setVisible(false);
            RespuestaSi.setDisable(true);
        }
    }

    @FXML
    private void RegresarPestania(ActionEvent event) {
        this.PreguntasHechas = 0;
        this.arbol = null;
        try {
            App.setRoot("primary");
        } catch (IOException ex) {
            Logger.getLogger(PreguntasYRespuestasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void respuestaSi() {
        PreguntasHechas++;
        this.arbol = this.arbol.getLeft();
    }

    private void respuestaNo() {
        PreguntasHechas++;
        this.arbol = this.arbol.getRight();
    }

    private void preguntar() {
        if (ArbolData.esPregunta(this.arbol.getRootContent())) {
            preguntas.setText(this.arbol.getRootContent());
        }

//       else{
//           preguntas.setText("Estas pensando en un "+ arbol.getRootContent());
//       }
    }

    private void darRespuesta(BinaryTree<String> guia) {
        if (guia == null) {
            preguntas.setText("Lo sentimos, pero no tenemos un animal que cumpla esa descripcion");
        } else if (!ArbolData.esPregunta(guia.getRootContent())) {
            preguntas.setText("Estas pensando en un " + arbol.getRootContent());
        } else if (ArbolData.esPregunta(guia.getRootContent())) {
            String respuesta = "";
            for (String respuestas : arbol.getHojas()) {
                respuesta += respuestas + ", ";
            }
            if (arbol.listaHojas().size() == 1) {
                preguntas.setText("Estas pensando en un " + respuesta);
            } else {
                preguntas.setText("Podrias estar pensando en estos animales" + respuesta);
            }
        }
    }

}

//      private void respuestaNo(){
//        PreguntasHechas++;
//        this.arbol=this.arbol.getRight();
//        if(arbol==null){
//            preguntas.setText("Lo sentimos, pero no tenemos un animal que cumpla esa descripcion");
//        }
//        if((PreguntasHechas==PreguntasUsuario)&& (!ArbolData.esPregunta(arbol.getRootContent()))){
//           preguntas.setText("Estas pensando en un "+ arbol.getRootContent());
//        }
//        if((PreguntasHechas==PreguntasUsuario)&& (arbol!=null)){
//            String respuesta="";
//            for(String respuestas : arbol.listaHojas()){
//                respuesta+=respuestas+", ";
//            }
//            preguntas.setText("Podrias estar pensando en estos animales"+respuesta);
//        }    
//    private void CambiarPregunta(){ 
//        int PreguntasHechas=0;
//        int PreguntasUsuario=2;
//        while(PreguntasHechas<=PreguntasUsuario){
//            if(ArbolData.esPregunta(arbol.getRootContent())){
//                System.out.println(arbol.getRootContent());
//                //preguntas.setText(arbol.getRootContent());
//                if(controladorRespuestas.equals("SI")){
//                    PreguntasHechas++;
//                    arbol=arbol.getLeft();
//                    if(arbol==null){
//                        System.out.println("Lo sentimos, pero no tenemos un animal que cumpla esa descripcion");
//                        break;
//                    }
//                    if((PreguntasHechas==PreguntasUsuario)&& (arbol!=null)){
//                        String respuesta="";
//                        for(String respuestas : arbol.listaHojas()){
//                            respuesta+=respuestas+", ";
//                        }
//                        //preguntas.setText("Podrias estar pensando en estos animales"+respuesta);
//                        System.out.println(respuesta);
//                        break;
//                    }
//                }else if(controladorRespuestas.equals("NO")){
//                    PreguntasHechas++;
//                    arbol=arbol.getRight();
//                    if(arbol==null){
//                        System.out.println("Lo sentimos, pero no tenemos un animal que cumpla esa descripcion");
//                        break;
//                    }
//                    if((PreguntasHechas==PreguntasUsuario)&& (arbol!=null)){
//                        String respuesta="";
//                        for(String respuestas : arbol.listaHojas()){
//                            respuesta+=respuestas+", ";
//                        }
//                        //preguntas.setText("Podrias estar pensando en estos animales"+respuesta);
//                        System.out.println(respuesta);
//                        break;
//                    }
//                }else if(controladorRespuestas.equals("")){
//                    System.out.println("aiuda");
//                    break;
//                }
//            }else{
//                //preguntas.setText("Estas pensando en un "+ arbol.getRootContent());
//                System.out.println(arbol.getRootContent());
//                break;
//            }
//        }
//    }

