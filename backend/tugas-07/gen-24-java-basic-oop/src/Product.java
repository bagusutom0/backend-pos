abstract class Product {
    private String nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    private String harga;

    void display() {
        System.out.println("Produk " + nama + " dengan harga " + harga);
    }
}
