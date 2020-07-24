/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rashid Maulana
 */
public class PemdaController implements Initializable {

    @FXML
    private final Button Tabel = new Button();
    
    @FXML
    private final Button Grafik = new Button();
    
    @FXML
    private final Button kembali = new Button();
    
    @FXML
    private void goToTabel(ActionEvent event) throws IOException {
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/table.fxml"));
        Scene noteScene = new Scene (NoteParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(noteScene);
        window.show();
    }
     
    @FXML
    private void goToGrafik(ActionEvent event) throws IOException {
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/Diagram.fxml"));
        Scene noteScene = new Scene (NoteParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(noteScene);
        window.show();
    }
    
    @FXML
    private void goToLogin(ActionEvent event) throws IOException {
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene noteScene = new Scene (NoteParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(noteScene);
        window.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
