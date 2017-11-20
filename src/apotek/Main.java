
package apotek;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List listTransaksi;
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Kasir> daftarKasir = new ArrayList();
        ArrayList<Obat> daftarObat = new ArrayList();
        ArrayList<Transaksi> daftarTrx = new ArrayList();
        
        //create object obat, pembeli, kasir
        Obat obt1 = new Obat("Obt001", "Paracetamol", 3000, "Generic", 12);
        Obat obt2 = new Obat("Obt002", "Amoxilin", 2000, "Generic", 8);
        Obat obt3 = new Obat("Obt003", "Combantren", 5000, "Generic", 6);
        Pembeli a1 = new Pembeli("P001","Kak Tedy", "081225390001", "E107");
        Pembeli a2 = new Pembeli("P002","Roki", "081225390234", "E107");
        Pembeli a3 = new Pembeli("P003","Adhi", "081225393456", "E107");
        Kasir kas1 = new Kasir("Kas001", "Tri", 2500000, "085123856983", "Kosan");
        Kasir kas2 = new Kasir("Kas002", "Ghalih", 2500000, "085123856983", "Kontrakan");
        Kasir kas3 = new Kasir("Kas003", "Nadda", 2500000, "085123856983", "Asrama");
        
        //add obat ke trx
        kas1.addTransaksi("trx001", a1);
        kas1.getTransaksi().get(0).beli(obt1);
        kas2.addTransaksi("trx002", a2);
        kas2.getTransaksi().get(0).beli(obt2);
        kas3.addTransaksi("trx003", a3);
        kas3.getTransaksi().get(0).beli(obt3);

        //add kasir ke daftarKasir
        daftarKasir.add(kas1);
        daftarKasir.add(kas2);
        daftarKasir.add(kas3);
        
        //add obat ke daftarObat
        daftarObat.add(obt1);
        daftarObat.add(obt2);
        daftarObat.add(obt3);
        
        //add transaksi ke daftarTrx
        daftarTrx.add(kas1.getTransaksi().get(0));
        daftarTrx.add(kas2.getTransaksi().get(0));
        daftarTrx.add(kas3.getTransaksi().get(0));
        
        System.out.println("======================================");
        System.out.println("Daftar Kasir");
        System.out.println("======================================");
        for (int i = 0; i < daftarKasir.size(); i++) {
            System.out.println("kasir-"+(i+1));
            System.out.println("ID      : "+daftarKasir.get(i).id);
            System.out.println("Nama    : "+daftarKasir.get(i).nama);
            System.out.println("NoHp    : "+daftarKasir.get(i).noHp);
            System.out.println("Alamat  : "+daftarKasir.get(i).alamat);
        }
        
        System.out.println("======================================");
        System.out.println("Daftar Obat");
        System.out.println("======================================");
        for (int i = 0; i < daftarObat.size(); i++) {
            System.out.println("Obat-"+(i+1));
            System.out.println("ID      : "+daftarObat.get(i).getId());
            System.out.println("Nama    : "+daftarObat.get(i).getNama());
            System.out.println("Tipe    : "+daftarObat.get(i).getTipeObat());
            System.out.println("Harga   : Rp "+daftarObat.get(i).getHarga());
            System.out.println("Jumlah  : "+daftarObat.get(i).getJum());
            
        }
        
        System.out.println("======================================");
        System.out.println("Daftar Transaksi");
        System.out.println("======================================");
        for (int i = 0; i < daftarKasir.size(); i++) {
            for (int j = 0; j < daftarKasir.get(i).getTransaksi().size(); j++) {
                System.out.println("Transaksi-"+(i+1));
                daftarTrx.get(i).buktiPembayaran();
                
            }
        }
        
    }
    
}
  