/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Rashid Maulana
 */
public class PetaniController implements Initializable {
    
    
    
    @FXML
    private final Button button1 = new Button();
    
    @FXML
    private final Button button2 = new Button();
    
    @FXML
    private final Button button3 = new Button();
    
    @FXML
    private final Button button4 = new Button();
    
    @FXML
    private final Button kembali = new Button();
   
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/Note.fxml"));
        Scene noteScene = new Scene (NoteParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(noteScene);
        window.show();
    }
    
    @FXML
    private void handleButtonAction2(ActionEvent event) throws IOException {
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/LookNote.fxml"));
        Scene noteScene = new Scene (NoteParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(noteScene);
        window.show();
    }
    
      @FXML
    private void handleButtonAction3(ActionEvent event) throws IOException {
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/EditNote.fxml"));
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
      
    
    public static String pilihFile(){
       String pathXML="";
       FileChooser fc = new FileChooser();
       fc.setInitialDirectory(new File (System.getProperty("user.dir")));
       fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));
       File xmlTerpilih = fc.showOpenDialog(null);
       if (xmlTerpilih == null){
           Alert warn = new Alert(AlertType.WARNING);
                    warn.setTitle("Perhatian");
                    warn.setHeaderText("File tidak dapat ditemukan.");
                    warn.setContentText("File tidak sudah dihapus atau file belum dibuat.");
                    warn.showAndWait();
       } else{
           pathXML = xmlTerpilih.getAbsolutePath();
       }
       return pathXML;
   }
    
    @FXML
    private void handleButtonAction4(ActionEvent event) throws IOException {
        String adXML = pilihFile();
        try  {
            File f= new File(adXML);
                if (f.delete()){  
                    Alert confirm = new Alert(AlertType.CONFIRMATION);
                    confirm.setTitle("Konfirmasi");
                    confirm.setHeaderText("File Berhasil dihapus.");
                    confirm.showAndWait();
                  } else {
                    Alert warn = new Alert(AlertType.WARNING);
                    warn.setTitle("Perhatian");
                    warn.setHeaderText("File tidak dapat dihapus.");
                    warn.setContentText("File tidak ada atau file tidak ditemukan.");
                    warn.showAndWait();
                  }    
          }           catch(Exception e)  {  
                        e.printStackTrace();  
      }
   }
    
       

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
