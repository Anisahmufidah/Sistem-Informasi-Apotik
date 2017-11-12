/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

/**
 *
 * @author akmalfdy
 */
public class TransaksiDetail {
    private Transaksi trx;
    private Obat obat;
    private int qty;
    private double harga;
    
    public TransaksiDetail(Transaksi trx, Obat obat, int qty, double harga){
        this.trx = trx;
        this.obat = obat;
        this.qty = qty;
        this.harga = harga;
    }
    
    /**
     * @return the trx
     */
    public Transaksi getTrx() {
        return trx;
    }

    /**
     * @param trx the trx to set
     */
    public void setTrx(Transaksi trx) {
        this.trx = trx;
    }

    /**
     * @return the obat
     */
    public Obat getObat() {
        return obat;
    }

    /**
     * @param obat the obat to set
     */
    public void setObat(Obat obat) {
        this.obat = obat;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the harga
     */
    public double getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }
    
}
