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
    private  BinaryTree<String> arbol= PrimaryController.arbolFinal;
    private int PreguntasHechas=0;
    private int PreguntasUsuario=3;
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
        RespuestaNo.setVisible(false);
        RespuestaSi.setVisible(false);
        preguntas.setText("POR FAVOR PIENSE EN UN ANIMAL");

    }    

    @FXML
    private void RespuestaSi(ActionEvent event) {
        respuestaSi();
        if(PreguntasHechas!=PreguntasUsuario){
            preguntar();
        }else{
            RespuestaSi.setVisible(false);
            RespuestaSi.setDisable(true);
            RespuestaNo.setVisible(false);
            RespuestaNo.setDisable(true);
        }
    }

    @FXML
    private void RespuestaNo(ActionEvent event) {
        respuestaNo();
        if(PreguntasHechas!=PreguntasUsuario){
            preguntar();
        }else{
            RespuestaNo.setVisible(false);
            RespuestaNo.setDisable(true);
            RespuestaSi.setVisible(false);
            RespuestaSi.setDisable(true);
        }    
    }

    @FXML
    private void RegresarPestania(ActionEvent event) {
        try {
            App.setRoot("primary");
        } catch (IOException ex) {
            Logger.getLogger(PreguntasYRespuestasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   

    @FXML
    private void PensarAnimal(ActionEvent event) {
        botonFirstTime.setVisible(false);
        botonFirstTime.setDisable(true);
        RespuestaSi.setVisible(true);
        RespuestaNo.setVisible(true);
        preguntas.setText(arbol.getRootContent());
    }

    private void respuestaSi(){
        PreguntasHechas++;
        arbol=arbol.getLeft();
        if(arbol==null){
            preguntas.setText("Lo sentimos, pero no tenemos un animal que cumpla esa descripcion");
        }
        if((PreguntasHechas==PreguntasUsuario)&& (arbol!=null)){
            String respuesta="";
            for(String respuestas : arbol.listaHojas()){
                respuesta+=respuestas+", ";
            }
            preguntas.setText("Podrias estar pensando en estos animales"+respuesta);
        }    
    }
    
    
    private void respuestaNo(){
        PreguntasHechas++;
        arbol=arbol.getRight();
        if(arbol==null){
            preguntas.setText("Lo sentimos, pero no tenemos un animal que cumpla esa descripcion");
        }
        if((PreguntasHechas==PreguntasUsuario)&& (arbol!=null)){
            String respuesta="";
            for(String respuestas : arbol.listaHojas()){
                respuesta+=respuestas+", ";
            }
            preguntas.setText("Podrias estar pensando en estos animales"+respuesta);
        }    
    }
                
   private void preguntar(){
       if(ArbolData.esPregunta(arbol.getRootContent())){
           preguntas.setText(arbol.getRootContent());
       }else{
           preguntas.setText("Estas pensando en un "+ arbol.getRootContent());
       }
   }
   
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
}
