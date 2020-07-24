/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Daerah;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Rahmatia
 */
public class DiagramController implements Initializable {
    XYChart.Series series;
    ArrayList<Daerah> dataDaerah;
    
    @FXML
    private BarChart grafikHasilPanen;
    
    @FXML 
    private CategoryAxis sumbuX;
    
    @FXML 
    private NumberAxis sumbuY;
    
    @FXML
    private TextField namaDaerah;
    
    @FXML
    private TextField jumlahPanen;
    
    @FXML 
    private Button buttonTambah = new Button();
    
    @FXML
    private Button kembali = new Button();

        
     @FXML
    private void handleButtonTambah(ActionEvent event) {
        try{
        dataDaerah.add(new Daerah(namaDaerah.getText(),Integer.parseInt(jumlahPanen.getText())));
        int jmlse= 0;
        int jmlbe = 0;
        for(Daerah dar : dataDaerah){
            if(dar.getHasilPanen() >= 150){ jmlse++;}
            else {jmlbe++;
                    }
        }
        series = new XYChart.Series();
        series.getData().add(new XYChart.Data("Sudah efisien", jmlse));
        series.getData().add(new XYChart.Data("Belum efisien", jmlbe));
        grafikHasilPanen.getData().add(series);
        } catch (Exception e){
            Alert warn = new Alert(Alert.AlertType.WARNING);
                    warn.setTitle("Perhatian");
                    warn.setHeaderText("Ada masukan yang salah.");
                    warn.setContentText("Silahkan masukkan tipe masukan yang benar");
                    warn.showAndWait();
        }
    }
    
    
    @FXML
   public void goToMenu(ActionEvent event) throws IOException{
        Parent NoteParent = FXMLLoader.load(getClass().getResource("/View/Pemda.fxml"));
        Scene noteScene = new Scene (NoteParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(noteScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dataDaerah = new ArrayList<>();
        dataDaerah.add(new Daerah("Pakem", 100));
        dataDaerah.add(new Daerah("Turi", 110));
        dataDaerah.add(new Daerah("Ngemplak", 150));
        dataDaerah.add(new Daerah("Tempel", 220));
        dataDaerah.add(new Daerah("Gamping", 320));
        dataDaerah.add(new Daerah("Cangkringan", 350));
        
        int jmlse= 0;
        int jmlbe = 0;
        for(Daerah dar : dataDaerah){
            if(dar.getHasilPanen() >= 150){ 
            jmlse++;
            } else {
                jmlbe++;}
        }
    
        series = new XYChart.Series();
        series.getData().add(new XYChart.Data("Sudah efisien", jmlse));
        series.getData().add(new XYChart.Data("Belum efisien", jmlbe));
        grafikHasilPanen.getData().add(series);
        
    }   
}
