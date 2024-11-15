public class Makanan extends Product{
    private String nama = super.nama;
    private String harga = super.harga;

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

    @Override
    void display() {
        System.out.println("Makanan " + nama + " dengan harga " + harga);
    }
}
