public class Obat extends Product{
    private String nama = super.nama;

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    private String harga = super.harga;

    @Override
    void display() {
        System.out.println("Obat " + nama + " dengan harga " + harga);
    }
}
