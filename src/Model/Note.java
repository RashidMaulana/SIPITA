package Model;


/**
 *
 * @author Rashid Maulana
 */
public class Note  {
   public String tanggal, judul, konten;
   public Note (String tgl, String jdl, String knt){
        this.judul = jdl;
        this.tanggal = tgl;
        this.konten = knt;
    }
   public Note(){}
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }
    
    @Override
    public String toString(){
        return this.judul;
    }
    
   }