/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rashid Maulana
 */
public class Daerah {
    private String nama;
    private int hasilPanen;

    public Daerah(String nama, int hasilPanen) {
        this.nama = nama;
        this.hasilPanen = hasilPanen;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHasilPanen() {
        return hasilPanen;
    }

    public void setHasilPanen(int hasilPanen) {
        this.hasilPanen = hasilPanen;
    }
    
    
}
