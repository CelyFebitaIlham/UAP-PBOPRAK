package kasir;

public class Produk {
    private String nama_produk;
    private double harga, diskon;
    private int jumlah;
    
    public Produk(String nama_produk, double harga, double diskon, int jumlah) {
        this.nama_produk = nama_produk;
        this.harga = harga;
        this.diskon = diskon;
        this.jumlah = jumlah;
    }

    public Produk() {
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    private double hargaDiskon(){
        return 0;
    }
}
