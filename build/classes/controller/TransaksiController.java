/*
* dibuat oleh Ucup Timposu
* Blog: www.timposu.com
* Email : ucup.timposu@gmail.com
* Silahkan kode ini dipelajari dan dikembangkan..
*
**/


package controller;

import model.Mahasiswa;
import model.dao.ImplementMahasiswa;
import model.dao.MahasiswaDAO;
import model.tabel.TabelModelMahasiswa;
import view.TransaksiForm;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ucup
 */
public class TransaksiController {

    private final TransaksiForm panel;
    private List<Mahasiswa> list;
    private final ImplementMahasiswa implementMahasiswa;
    
    public TransaksiController() {
        this.panel = new TransaksiForm();
        implementMahasiswa = new MahasiswaDAO();
        list = implementMahasiswa.getAllMahasiswa();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtNama().setText("");
        panel.getTxtAlamat().setText("");
        panel.getTabelMahasiswa().clearSelection();
    }
    
    public void isiTabel(){
        list = implementMahasiswa.getAllMahasiswa();
        panel.getTabelMahasiswa().setModel(new TabelModelMahasiswa(list));
        
    }
    
    public  void getDataField(){
        
        int row = panel.getTabelMahasiswa().getSelectedRow();
        
        if (row != -1){
            
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtNama().setText(list.get(row).getNama());
            panel.getTxtAlamat().setText(list.get(row).getAlamat());
            
        }
       
    }
    
    public void insert(){
        
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNama(panel.getTxtNama().getText());
        mahasiswa.setAlamat(panel.getTxtAlamat().getText());
        
        implementMahasiswa.input(mahasiswa);
    }

    public void update(){
        
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setId(Integer.parseInt(panel.getTxtId().getText()));
        mahasiswa.setNama(panel.getTxtNama().getText());
        mahasiswa.setAlamat(panel.getTxtAlamat().getText());
        
        implementMahasiswa.update(mahasiswa);
    
    }
    
    public void delete(){
        
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "No data deleted....? ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int row = Integer.parseInt(panel.getTxtId().getText());
        
        implementMahasiswa.delete(row);
        
    }
    
    
    public void getData(){
        
        if (panel.getTxtNama().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Isi data Nama yang mau di cari....? ", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String nama = panel.getTxtNama().getText();
        
        implementMahasiswa.getMahasiswa(nama);
        isiTabelCari(nama);
    }

   public void isiTabelCari(String nama){
        
        list = implementMahasiswa.getMahasiswa(nama);
        panel.getTabelMahasiswa().setModel(new TabelModelMahasiswa(list));
    }
}
    

