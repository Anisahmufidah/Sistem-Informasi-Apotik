/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import java.util.List;
import model.Transaksi;
/**
 *
 * @author akmalfdy
 */
public interface TransaksiDao {
   public List<Transaksi> getAllTransaksi();
   public Transaksi getTransaksi(int id);
   public void insertTransaksi(Transaksi transaksi);
   public void updateTransaksi(Transaksi transaksi);
   public void deleteTransaksi(Transaksi transaksi);
}
