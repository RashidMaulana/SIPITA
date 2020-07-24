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
import java.io.FileInputStream;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//import static sipita.LookNoteController.pilihFile;

/**
 * FXML Controller class
 *
 * @author Rashid Maulana
 */
public class EditNoteController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @FXML
    private TextField judul;
    
    @FXML
    private TextArea konten;
    
    @FXML
    private DatePicker tanggal;
    
    @FXML
    private Button kembali = new Button();
    
    @FXML
    private Button simpan = new Button();
    
    String adXML= pilihFile();
    
    @FXML
    public void ButtonHandleKembali(ActionEvent event) throws IOException{
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
           Alert warn = new Alert(Alert.AlertType.WARNING);
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
    public void ButtonHandleSimpan (ActionEvent event) throws IOException{
         String texttanggal = tanggal.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
         String textkonten = konten.getText();
         String textjudul = judul.getText();
         Note n01 = new Note(texttanggal,textjudul,textkonten);
        XStream xstream = new XStream (new StaxDriver());
        String sxml = xstream.toXML(n01);
        FileOutputStream f = null;
        try{
            f = new FileOutputStream(adXML);
            byte[] bytes = sxml.getBytes("UTF-8");
            f.write(bytes);
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                    confirm.setTitle("Konfirmasi");
                    confirm.setHeaderText("File Berhasil disimpan.");
                    confirm.showAndWait();
            f.close();
        }catch(Exception e){
            System.out.println("Perhatian: " + e.getMessage());
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Note n01 = new Note();
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream f = null;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
        LocalDate date = LocalDate.parse(b, formatter);
        tanggal.setValue(date);
        konten.setText(c);
    }    
    
}
