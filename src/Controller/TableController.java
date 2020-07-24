/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.table;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author umamil
 */
public class TableController implements Initializable {

@FXML 
private TableView<table> Tabel;

@FXML
private TableColumn<table, String> nama;

@FXML
private TableColumn<table, String> noKontak;

@FXML
private TableColumn<table, String> loc;

@FXML
private TableColumn<table, Integer> usia;

@FXML
private TextField name;
@FXML
private TextField kontak;
@FXML
private TextField lokasi;
@FXML
private TextField umur;

@FXML
private Button simpan = new Button();
@FXML
private Button kembali = new Button();
@FXML
private Button hapus = new Button();

@FXML
private void buttonKembali(ActionEvent event) throws IOException {
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/Pemda.fxml"));
        Scene noteScene = new Scene (NoteParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(noteScene);
        window.show();
    }

@FXML
private void buttonSimpan (ActionEvent event) throws IOException{
    try{
    int tempUmur = Integer.parseInt(umur.getText());
    table newTable = new table(name.getText(),lokasi.getText(), tempUmur, kontak.getText());
    Tabel.getItems().add(newTable);
    } catch(Exception e){
       Alert warn = new Alert(Alert.AlertType.WARNING);
                    warn.setTitle("Perhatian");
                    warn.setHeaderText("Ada masukan yang salah.");
                    warn.setContentText("Silahkan masukkan tipe masukan yang benar");
                    warn.showAndWait();
    }
    
}

@FXML
private void buttonHapus (ActionEvent event) throws IOException{
    ObservableList<table> barisTerpilih, semuaPetani;
    semuaPetani = Tabel.getItems();
    
    barisTerpilih = Tabel.getSelectionModel().getSelectedItems();
    
    for (table t : barisTerpilih){
        semuaPetani.remove(t);
    }
}

@FXML
public void gantiNama (CellEditEvent editCell){
    table tableSelected = Tabel.getSelectionModel().getSelectedItem();
    tableSelected.setNama(editCell.getNewValue().toString());
}

@FXML
public void gantiLokasi (CellEditEvent editCell){
    table tableSelected = Tabel.getSelectionModel().getSelectedItem();
    tableSelected.setLoc(editCell.getNewValue().toString());
}

@FXML
public void gantiNoKontak (CellEditEvent editCell){
    table tableSelected = Tabel.getSelectionModel().getSelectedItem();
    tableSelected.setNoKontak(editCell.getNewValue().toString());
}

@FXML
public void gantiUsia (CellEditEvent editCell){
    table tableSelected = Tabel.getSelectionModel().getSelectedItem();
    tableSelected.setUsia((int) editCell.getNewValue());
}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //untuk start menentukan tabel
        nama.setCellValueFactory(new PropertyValueFactory<table, String>("nama"));
        noKontak.setCellValueFactory(new PropertyValueFactory<table, String>("noKontak"));
        loc.setCellValueFactory(new PropertyValueFactory<table, String>("loc"));
        usia.setCellValueFactory(new PropertyValueFactory<table, Integer>("usia"));
        Tabel.setItems(loadPetani());
        // ini untuk ngedit petani
        Tabel.setEditable(true);
        nama.setCellFactory(TextFieldTableCell.forTableColumn());
        noKontak.setCellFactory(TextFieldTableCell.forTableColumn());
        loc.setCellFactory(TextFieldTableCell.forTableColumn());
        usia.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //ini agar bisa menyeleksi beberapa data
        Tabel.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
    }    
    
    
    
    public ObservableList<table> loadPetani(){
     ObservableList<table> list = FXCollections.observableArrayList();
     list.add(new table ("Rashid", "Jogjakarta", 18, "081925"));
     list.add(new table ("Tia", "Depok", 18, "082571"));
     return list;
    }
}
