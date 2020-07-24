package Controller;

import Model.Note;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rashid Maulana
 */
public class LookNoteController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @FXML
    private TextArea konten;
    
    @FXML
    private TextField tanggal;
    
    @FXML
    private TextField judul;
    
    @FXML
    private Button kembali = new Button();
    
    @FXML
   public void handleButtonKembali(ActionEvent event) throws IOException{
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/Petani.fxml"));
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Note n01 = new Note();
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream f = null;
        String adXML = pilihFile();
        try{
            f = new FileInputStream(adXML);
            int isi;
            char c;
            String sxml= "" ;
            while((isi = f.read()) != -1){
                c = (char) isi;
                sxml = sxml + c;
            } n01 =(Note) xstream.fromXML(sxml);
        }catch (IOException e){
            Alert warn = new Alert(Alert.AlertType.WARNING);
                    warn.setTitle("Perhatian");
                    warn.setHeaderText("Note tidak dapat ditemukan.");
                    warn.setContentText("Silahkan buat note terlebih dahulu.");
                    warn.showAndWait();
        }
        finally{
            if (f != null){
                try{
                    f.close();
                }catch(IOException e){
                }
            }
        }
        String a, b, c;
        a = n01.getJudul();
        b = n01.getTanggal();
        c = n01.getKonten();
        judul.setText(a);
        tanggal.setText(b);
        konten.setText(c);
    }    
    
}
