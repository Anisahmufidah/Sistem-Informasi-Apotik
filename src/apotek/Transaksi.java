package apotek;

import java.util.ArrayList;

public class Transaksi {
    private String id;
    private Pembeli pembeli;
    private Kasir kasir;
    private ArrayList<Obat> obat;
    private int jumObat;
    private double totalharga;
    
    public Transaksi(String id, Pembeli pembeli, Kasir kasir) {
        this.id = id;
        this.pembeli = pembeli;
        this.kasir = kasir;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public void setKasir(Kasir kasir) {
        this.kasir = kasir;
    }

    public void setObat(ArrayList<Obat> obat) {
        this.obat = obat;
    }

    public void setJumObat(int jumObat) {
        this.jumObat = jumObat;
    }

    public void setTotalharga(double totalharga) {
        this.totalharga = totalharga;
    }

    public String getId() {
        return id;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public Kasir getKasir() {
        return kasir;
    }

    public ArrayList<Obat> getObat() {
        return obat;
    }

    public int getJumObat() {
        return jumObat;
    }

    public double getTotalharga() {
        return totalharga;
    }
    
    @Override
    public String toString() {
        return "Transaksi{" + "id=" + id + ", pembeli=" + pembeli + ", kasir=" + kasir + ", obat=" + obat + ", jumObat=" + jumObat + ", totalharga=" + totalharga + '}';
    }
    
    
    
}
