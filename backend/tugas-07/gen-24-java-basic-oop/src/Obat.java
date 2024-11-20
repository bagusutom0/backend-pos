public class Obat extends Product{


    @Override
    void display() {
        System.out.println("Obat " + getNama() + " dengan harga " + getHarga() );
    }
}
