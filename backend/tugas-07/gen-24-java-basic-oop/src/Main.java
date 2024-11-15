public class Main {
    public static void main(String[] args) {
//        makanan
        Makanan mieInstan1 = new Makanan();
        mieInstan1.setNama("Indomie");
        mieInstan1.setHarga("4000");
        mieInstan1.display();

        Makanan mieInstan2 = new Makanan();
        mieInstan2.setNama("Sarimi");
        mieInstan2.setHarga("3800");
        mieInstan2.display();

        Makanan mieInstan3 = new Makanan();
        mieInstan3.setNama("Pasta");
        mieInstan3.setHarga("10000");
        mieInstan3.display();

//        minuman
        Minuman minuman1 = new Minuman();
        minuman1.setNama("Aqua");
        minuman1.setHarga("3000");
        minuman1.display();

        Minuman minuman2 = new Minuman();
        minuman2.setNama("Golda Coffee");
        minuman2.setHarga("3200");
        minuman2.display();

        Minuman minuman3 = new Minuman();
        minuman3.setNama("Nescaffe");
        minuman3.setHarga("18000");
        minuman3.display();

//        obat
        Obat obat1 = new Obat();
        obat1.setNama("Paracetamol");
        obat1.setHarga("5000");
        obat1.display();

        Obat obat2 = new Obat();
        obat2.setNama("Bodrex");
        obat2.setHarga("6000");
        obat2.display();

        Obat obat3 = new Obat();
        obat3.setNama("Ultraflue");
        obat3.setHarga("4000");
        obat3.display();
    }
}