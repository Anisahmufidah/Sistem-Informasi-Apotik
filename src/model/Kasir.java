
package model; 

import java.util.ArrayList;

public class Kasir extends Orang{
    private int gaji;
    private int shift;
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList();
    
    public Kasir(String id, String pwd, String nama, int gaji,String noHp, String alamat) {
        this.id = id;
        this.pwd = pwd;
        this.nama = nama;
        this.gaji = gaji;
        this.noHp = noHp;
        this.alamat = alamat;
    }
    
    public Kasir(){
    };
    
    public void addTransaksi (String id, Pembeli pembeli){
        this.daftarTransaksi.add(new Transaksi(id, pembeli, this));
    }
    
    public  void showAllTransaksi() {
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            System.out.println("ID  : "+daftarTransaksi.get(i).getId());
            System.out.println("ID-Pembeli  : "+daftarTransaksi.get(i).getPembeli().id);
            System.out.println("ID-Kasir    : "+daftarTransaksi.get(i).getKasir().id);
        }
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public int getGaji() {
        return gaji;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public int getShift() {
        return shift;
    }

    public ArrayList<Transaksi> getTransaksi() {
        return daftarTransaksi;
    }

    Object Transaksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}