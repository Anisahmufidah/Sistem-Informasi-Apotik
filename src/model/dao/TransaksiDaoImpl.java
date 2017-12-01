/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Kasir;
import model.Pembeli;
import model.Transaksi;

/**
 *
 * @author akmalfdy
 */
public class TransaksiDaoImpl implements TransaksiDao{
    //list is working as a database
   public List<Transaksi> listTransaksi;
   Connection conn = null;

   public TransaksiDaoImpl(){
        listTransaksi = new ArrayList<Transaksi>();
        conn = ConnectionDatabase.getConnection();
   }

    @Override
    public List<Transaksi> getAllTransaksi() {
        
        try {
            
            Statement statement = conn.createStatement();
            ResultSet result, result2, result3;
            result = statement.executeQuery(""
                    + "SELECT transaksi.*, pembeli.nama as namaPembeli, pembeli.alamat as alamatPembeli, kasir.nama as namaKasir, kasir.alamat as alamatKasir FROM transaksi"
                    + " JOIN orang pembeli ON transaksi.idPembeli = pembeli.idOrang"
                    + " JOIN orang kasir ON transaksi.idKasir = kasir.idOrang");
            
            while (result.next()) { 
                Transaksi transaksi = new Transaksi();
                Kasir kasir = new Kasir();
                Pembeli pembeli = new Pembeli();
                
                transaksi.setId(result.getString("idTransaksi"));
                transaksi.setTotalharga(result.getInt("totalHarga"));
                transaksi.setTglTrx(result.getDate("tglTrx"));
                kasir.setId(result.getString("idKasir"));
                kasir.setNama(result.getString("namaKasir"));
                kasir.setAlamat(result.getString("alamatKasir"));
                pembeli.setId(result.getString("idPembeli"));
                pembeli.setNama(result.getString("namaPembeli"));
                pembeli.setAlamat(result.getString("alamatPembeli"));
                transaksi.setKasir(kasir);
                transaksi.setPembeli(pembeli);
                
                listTransaksi.add(transaksi);
            }
            
            result.close();
            
            statement.close();
            
            return listTransaksi;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
    }

    @Override
    public Transaksi getTransaksi(int id) {
        Transaksi transaksi = new Transaksi();
        Kasir kasir = new Kasir();
        Pembeli pembeli = new Pembeli();
        
        try {
            
            Statement statement = conn.createStatement();
            ResultSet result, result2, result3;
            result = statement.executeQuery("SELECT * FROM transaksi WHERE idTransaksi = " + id);
            
            while (result.next()) { 
                
                transaksi.setId(result.getString("idTransaksi"));
                transaksi.setTotalharga(result.getInt("totalHarga"));
                transaksi.setTglTrx(result.getDate("tglTrx"));
                kasir.setId(result.getString("idKasir"));
                pembeli.setId(result.getString("idPembeli"));
                
            }
            
            
            result2 = statement.executeQuery("SELECT * FROM orang WHERE idOrang = " + kasir.getId());
            
            while (result2.next()) { 
                
                kasir.setNama(result2.getString("nama"));
                kasir.setNoHp(result2.getString("noHp"));
                kasir.setAlamat(result2.getString("alamat"));
            }
            transaksi.setKasir(kasir);
            
            
            
            result3 = statement.executeQuery("SELECT * FROM orang WHERE idOrang = " + pembeli.getId());
            
            while (result3.next()) { 
                
                pembeli.setNama(result3.getString("nama"));
                pembeli.setNoHp(result3.getString("noHp"));
                pembeli.setAlamat(result3.getString("alamat"));
            }
            transaksi.setPembeli(pembeli);
            
            result.close();
            result2.close();
            result3.close();
            
            statement.close();
            
            return transaksi;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
    }

    @Override
    public void insertTransaksi(Transaksi transaksi) {
        try {
            PreparedStatement statement = conn.prepareStatement(""
                    + "INSERT INTO transaksi (idTransaksi, idPembeli, idKasir, tglTrx, totalHarga) VALUES (null, ?, ?, ?, ?)");
            
//            statement.setString(1, transaksi.getNama());
//            statement.setString(2, transaksi.getAlamat());
//            statement.setString(3, transaksi.getAlamat());
//            statement.setString(4, transaksi.getAlamat());
            
            statement.executeUpdate();
          
          
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateTransaksi(Transaksi transaksi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTransaksi(Transaksi transaksi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
