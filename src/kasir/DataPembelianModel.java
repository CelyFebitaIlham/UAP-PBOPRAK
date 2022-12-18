package kasir;

import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataPembelianModel {
    private final Connection CONN;

    public DataPembelianModel(){
        this.CONN = DBHelper.getConnection();
    }

    public void addDataPembelian(Penjualan pjl){
        String insert = "INSERT INTO data_pembelian VALUES ('" + pjl.getProduk() + "'," + pjl.getJumlahProduk() + ");";

        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Data berhasil dimasukkan");
            }
            else{
                System.out.println("Data gagal dimasukkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataPembelianModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data gagal dimasukkan");
        }
    }
    public void deleteDataPembelian(Penjualan pjl){
        String delete = "DELETE FROM data_pembelian WHERE Produk = '" + pjl.getProduk() + "';";
        
        try {
            if(CONN.createStatement().executeUpdate(delete) > 0){
                System.out.println("Data berhasil dihapus");
            }
            else{
                System.out.println("Data berhasil dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataPembelianModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal meng-Hapus Data");
        }
    }
}
