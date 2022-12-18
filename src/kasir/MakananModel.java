package kasir;

import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MakananModel {
    private final Connection CONN;

    public MakananModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addMakanan(Makanan mkn){
        String insert = "INSERT INTO makanan VALUES (" +
                        mkn.getId() + ", " + mkn.getDaya_tahan() + ", '" +
                        mkn.getNama_produk() + "', " + mkn.getHarga() + ", " +
                        mkn.getJumlah() + ", " + mkn.getDiskon() + ");";
        
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Data berhasil dimasukkan");
            }
            else{
                System.out.println("Data gagal dimasukkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data gagal dimasukkan");
        }
    }
    
    public void deleteMakanan(Makanan mkn){
        String delete = "DELETE FROM makanan WHERE id = " +
                        mkn.getId() + ";";
        
        try {
            if(CONN.createStatement().executeUpdate(delete) > 0){
                System.out.println("Data berhasil dihapus");
            }
            else{
                System.out.println("Data berhasil dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal meng-Hapus Data");
        }
    }
    
    public ArrayList<Makanan> getMakanan(){
        String query = "SELECT * FROM makanan;";
        ArrayList<Makanan> mkn1 = new ArrayList<Makanan>();
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Makanan temp = new Makanan(rs.getString("nama_produk"), rs.getDouble("harga"),
                                            rs.getDouble("diskon"), rs.getInt("jumlah"),
                                            rs.getInt("id"), rs.getInt("daya_tahan"));
                mkn1.add(temp);
            }
            System.out.println("Berhasil mengambil data");
        } 
        catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal mengambil data");
        }
        
        return mkn1;
    }
}
