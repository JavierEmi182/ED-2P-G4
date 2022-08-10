/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos.grupo_04;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Javier
 */
public class FileChooserController implements Initializable {

    @FXML
    private Button btnBuscar;
    @FXML
    private Label lbMensajeError;
    private ImageView ivImagen;
    
    ///
    private File fileSeleccionado;
    private String rutaAnterior;
    @FXML
    private Label lbNumPreguntas;
    @FXML
    private Button btnCargarTexto;
    @FXML
    private Label lbDescripcion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbMensajeError.setText("");
        // TODO
        btnBuscar.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar Imagen");

            // Agregar filtros para facilitar la busqueda
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );

            // Obtener la imagen seleccionada
            File imgFile = fileChooser.showOpenDialog(null);
            fileSeleccionado = imgFile;

            // Mostar la imagen
            if (imgFile != null) {
                Image image = new Image("file:" + imgFile.getAbsolutePath());
                ivImagen.setImage(image);
                rutaAnterior = imgFile.getAbsolutePath();
            }
        });
    }    


    @FXML
    private void volver(ActionEvent event) {
    }

    @FXML
    private void cargarTexto(ActionEvent event) {
    }
    
}
