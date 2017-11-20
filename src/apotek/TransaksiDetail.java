package apotek;
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
    
    public Transaksi getTrx() {
        return trx;
    }

    public void setTrx(Transaksi trx) {
        this.trx = trx;
    }

    public Obat getObat() {
        return obat;
    }

    public void setObat(Obat obat) {
        this.obat = obat;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
}
