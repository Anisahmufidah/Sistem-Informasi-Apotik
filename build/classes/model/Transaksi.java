package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Transaksi {
    private String id;
    private Pembeli pembeli;
    private Kasir kasir;
    private ArrayList<Obat> obat;
    private ArrayList<TransaksiDetail> trxDetail = new ArrayList();
    private Date tglTrx;
    private int jumObat;
    private double totalharga = 0;
    
    public Transaksi(String id, Pembeli pembeli, Kasir kasir) {
        this.id = id;
        this.pembeli = pembeli;
        this.kasir = kasir;
    }
    
    public Transaksi(){
        
    }
    
    public void beli(Obat obat){
        this.trxDetail.add(new TransaksiDetail(this, obat, 1, obat.getHarga()));
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
        for(TransaksiDetail detail: trxDetail){
            this.totalharga = this.totalharga + detail.getHarga();
        }
        
        return this.totalharga;
    }
    
    public void buktiPembayaran(){
        System.out.println("Bukti Pembayaran\n\n");
        System.out.println("Tanggal     : " + this.getCurrentDate());
        System.out.println("ID-Kasir    : "+kasir.id);
        System.out.println("ID-Pembeli  : "+pembeli.id + "\n\n");
        System.out.println("-------------------------------------------");
        System.out.println("Nama Obat \tQty \t\tHarga");
        System.out.println("-------------------------------------------");
        for(TransaksiDetail detail: trxDetail){
            System.out.println(detail.getObat().getNama() + "\t" + detail.getQty() + "\t\t" + detail.getHarga());
        }
        System.out.println("-------------------------------------------");
        System.out.println("\t\tTotal Harga : \t" + this.getTotalharga());
    }
    
    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        
        return dateFormat.format(date);
    }
    
    @Override
    public String toString() {
        return "Transaksi{" + "id=" + id + ", pembeli=" + pembeli + ", kasir=" + kasir + ", obat=" + obat + ", jumObat=" + jumObat + ", totalharga=" + totalharga + '}';
    }
    
    
    
}
