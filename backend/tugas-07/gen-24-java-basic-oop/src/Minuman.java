public class Minuman extends Product {


    @Override
    void display() {
        System.out.println("Minuman " + getNama() + " dengan harga " + getHarga());
    }
}
