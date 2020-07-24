/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Note;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.XStream;
import java.io.*;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * FXML Controller class
 *
 * @author Rashid Maulana
 */
public class NoteController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @FXML
    private TextArea konten;
    
    @FXML
    private TextField judul;
    
    @FXML
    private DatePicker tanggal;
    
    @FXML
    private Button kembali = new Button();
    
    @FXML
    private Button simpan = new Button();
    
    public void handleButtonKembali(ActionEvent event) throws IOException{
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/Petani.fxml"));
        Scene noteScene = new Scene (NoteParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(noteScene);
        window.show();
    }
    
    private static File chooseFile (Window stage){
        FileChooser fc = new FileChooser();
       fc.setInitialDirectory(new File (System.getProperty("user.dir")));
       fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));
       File xmlTerpilih = fc.showSaveDialog(stage);
       return xmlTerpilih;
    }
    
    @FXML
    private void handleButtonSimpan(ActionEvent event){
        String texttanggal = tanggal.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String textkonten = konten.getText();
        String textjudul = judul.getText();
        Note n01 = new Note(texttanggal,textjudul,textkonten); 
        Window scene = konten.getScene().getWindow();
        
        XStream xstream = new XStream (new StaxDriver());
        String sxml = xstream.toXML(n01);
        FileOutputStream f = null;
        try{
            f = new FileOutputStream(chooseFile(scene));
            byte[] bytes = sxml.getBytes("UTF-8");
            f.write(bytes);
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                    confirm.setTitle("Konfirmasi");
                    confirm.setHeaderText("File Berhasil disimpan.");
                    confirm.showAndWait();
        }catch(Exception e){
            Alert warn = new Alert(Alert.AlertType.WARNING);
                    warn.setTitle("Perhatian");
                    warn.setHeaderText("Note tidak dapat dibuat.");
                    warn.setContentText("Terjadi kesalahan saat menyimpan note : " + e.getMessage());
                    warn.showAndWait();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
