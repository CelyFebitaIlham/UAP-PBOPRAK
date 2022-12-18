package kasir;

import java.util.ArrayList;

public class Barang extends Produk {
    private String barcode, expired;
    private ArrayList<Kategori> kategori1 = new ArrayList<>();
    private String category;

    public Barang(String nama_produk, double harga, double diskon, int jumlah, String barcode, String expired, String category) {
        super(nama_produk, harga, diskon, jumlah);
        this.barcode = barcode;
        this.expired = expired;
        this.category = category;
    }

    public Barang() {
    }

    public Barang(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public ArrayList<Kategori> getKategori1() {
        return kategori1;
    }

    public void setKategori1(ArrayList<Kategori> kategori1) {
        this.kategori1 = kategori1;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public Boolean isExpired(){
        return true;
    }
    
    public String addKategori(Kategori k){
        return null;
    }
}
