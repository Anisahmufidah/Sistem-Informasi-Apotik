
package apotek;

import java.util.ArrayList;
import java.util.List;

public class Apotek {
    private List listTransaksi;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Obat obt1 = new Obat("Obt001", "Paracetamol", 3000, "Generic", 12);
        Obat obt2 = new Obat("Obt002", "Amoxilin", 2000, "Generic", 8);
        Obat obt3 = new Obat("Obt003", "Combantren", 5000, "Generic", 6);
        Pembeli a1 = new Pembeli("P001","Kak Tedy", "081225390001", "E107");
        Pembeli a2 = new Pembeli("P002","Roki", "081225390234", "E107");
        Pembeli a3 = new Pembeli("P003","Adhi", "081225393456", "E107");
        Kasir kas1 = new Kasir("Kas001", "Tri", 2500000, "085123856983", "Kosan");
        
        Transaksi trx1 = new Transaksi("trx01", a1, kas1);
        trx1.beli(obt1);
        trx1.beli(obt2);
        
        trx1.buktiPembayaran();
        
//        kas1.addTransaksi("Trx001", a1);
//        System.out.println("Menampilkan Nama Kasir dari suatu transaksi :");
//        System.out.println(kas1.getTransaksi().get(0).getKasir().getNama());
//        System.out.println("Menampilkan alamat kasir :");
//        System.out.println(kas1.alamat);
    }
    
}
  