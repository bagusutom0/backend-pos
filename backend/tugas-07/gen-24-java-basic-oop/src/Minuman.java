public class Minuman extends Product {
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

    private String nama = super.nama;
    private String harga = super.harga;

    @Override
    void display() {
        System.out.println("Minuman " + nama + " dengan harga " + harga);
    }
}
