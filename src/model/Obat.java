package model;

public class Obat {
    private String id;
    private String nama;
    private int harga;
    private String tipeObat;
    private int jum;

    public Obat(String id, String nama, int harga, String tipeObat, int jum) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.tipeObat = tipeObat;
        this.jum = jum;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setTipeObat(String tipeObat) {
        this.tipeObat = tipeObat;
    }

    public void setJum(int jum) {
        this.jum = jum;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public String getTipeObat() {
        return tipeObat;
    }

    public int getJum() {
        return jum;
    }
    
    
}
