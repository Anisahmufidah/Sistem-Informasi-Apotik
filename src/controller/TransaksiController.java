/*
* dibuat oleh Ucup Timposu
* Blog: www.timposu.com
* Email : ucup.timposu@gmail.com
* Silahkan kode ini dipelajari dan dikembangkan..
*
**/


package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import view.TransaksiForm;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Transaksi;
import model.dao.TransaksiDao;
import model.dao.TransaksiDaoImpl;

/**
 *
 * @author ucup
 */
public class TransaksiController extends MouseAdapter implements ActionListener {

    private TransaksiForm view;
    private TransaksiDao transaksiDao;
    
    public TransaksiController() {
        transaksiDao = new TransaksiDaoImpl();
        view = new TransaksiForm();
        view.addActionListener(this);
//        view.addMouseAdapter(this);
        view.setVisible(true);

        initTable();
    }
    
    public void refresh(){
        initTable();
    }
    
    public void initTable(){
        DefaultTableModel model = new DefaultTableModel();
        
        view.getTableTransaksi().setModel(model);
        model.addColumn("Id");
        model.addColumn("Pembeli");
        model.addColumn("Kasir");
        model.addColumn("Tanggal");
        model.addColumn("Total Harga");
        
        for(Transaksi t: transaksiDao.getAllTransaksi()){
            
            Object[] o = new Object[5];
            o[0] = t.getId();
            o[1] = t.getPembeli().getNama();
            o[2] = t.getKasir().getNama();
            o[3] = t.getTglTrx().toString();
            o[4] = t.getTotalharga();
            model.addRow(o);
        }

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        System.out.println("asd " + source.equals(view.getTombolRefresh()));
        if (source.equals(view.getTombolRefresh())){
            refresh();
        }
//        else if (source.equals(view.getBtnDelete())){
//            int i = view.getSelectedPeserta();
//            daftarPeserta.remove(i);
//            view.resetView();
//            view.setId(Peserta.getId());
//            view.setDaftarPeserta(getDaftarPeserta());
//        }
    }
    
    
}
    

