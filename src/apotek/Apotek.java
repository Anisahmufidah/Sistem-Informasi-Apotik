
package apotek;

public class Apotek {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Obat obt1 = new Obat("Obt001", "Paracetamol", 12, "Generic", 3000);
        Obat obt2 = new Obat("Obt002", "Amoxilin", 8, "Generic", 1000);
        Obat obt3 = new Obat("Obt003", "Combantren", 10, "Generic", 13000);
        Pembeli a1 = new Pembeli("P001","Kak Tedy", "081225390001", "E107");
        Pembeli a2 = new Pembeli("P002","Roki", "081225390234", "E107");
        Pembeli a3 = new Pembeli("P003","Adhi", "081225393456", "E107");
        Kasir kas1 = new Kasir("Kas001", "Tri", 2500000, "085123856983", "Kosan");
        Kasir kas2 = new Kasir("Kas002", "Ghalih", 2200000, "08923476509", "Kosan");
        
        kas1.addTransaksi("Trx001", a1);
        System.out.println("Menampilkan Nama Kasir dari suatu transaksi :");
        System.out.println(kas1.getTransaksi().get(0).getKasir().getNama());
        System.out.println("Menampilkan alamat kasir :");
        System.out.println(kas1.alamat);
    }
    
}
  