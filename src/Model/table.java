/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author umamil
 */
public class table{
    private SimpleStringProperty nama, loc, noKontak;
    private SimpleIntegerProperty usia;
    
    public table(String nama, String loc, int usia, String noKontak) {
        this.nama = new SimpleStringProperty(nama);
        this.loc = new SimpleStringProperty(loc);
        this.usia = new SimpleIntegerProperty(usia);
        this.noKontak = new SimpleStringProperty(noKontak);
    }


    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama = new SimpleStringProperty(nama);
    }

    public String  getLoc() {
        return loc.get();
    }

    public void setLoc(String loc) {
        this.loc = new SimpleStringProperty(loc);
    }

    public Integer getUsia() {
        return usia.get();
    }

    public void setUsia(int usia) {
        this.usia = new SimpleIntegerProperty(usia);
    }

    public String getNoKontak() {
        return noKontak.get();
    }

    public void setNoKontak(String noKontak) {
        this.noKontak = new SimpleStringProperty(noKontak);
    }
    
    
    
}
