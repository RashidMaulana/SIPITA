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
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private final Button petani = new Button();
    
    @FXML
    private final Button pemda = new Button();
    
    @FXML
    public void goToPetani(ActionEvent event) throws IOException{
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/Petani.fxml"));
        Scene noteScene = new Scene (NoteParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(noteScene);
        window.show();
    }
    
    @FXML
    public void goToPemda(ActionEvent event) throws IOException{
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/Pemda.fxml"));
        Scene noteScene = new Scene (NoteParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(noteScene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
