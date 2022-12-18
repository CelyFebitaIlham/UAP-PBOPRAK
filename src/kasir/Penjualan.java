package kasir;

public class Penjualan implements ProductCounter{
    private int jumlahProduk, stok;
    private String produk;

    public Penjualan(int jumlahProduk, int stok) {
        this.jumlahProduk = jumlahProduk;
        this.stok = stok;
    }

    public Penjualan(int jumlahProduk, String produk) {
        this.jumlahProduk = jumlahProduk;
        this.produk = produk;
    }

    public Penjualan(String produk) {
        this.produk = produk;
    }

    public int getJumlahProduk() {
        return jumlahProduk;
    }

    public void setJumlahProduk(int jumlahProduk) {
        this.jumlahProduk = jumlahProduk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }


    @Override
    public int hitungJumlahProduk(){
        return 0;
    }

    @Override
    public double hitungHargaProduk(){
        return 0;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }
}
