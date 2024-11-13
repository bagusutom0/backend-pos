import java.util.Scanner;

public class ValidasiInputSpesifik {
    public ValidasiInputSpesifik() {
        System.out.println("Harga mie ayam: 5000, cuma bisa beli 1 le");
        System.out.print("Masukan uang: ");
        int duit = 0;
        try {
            duit = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Yang bener lah, masukin angka le");
        } finally {
            System.out.println(duit >= 5000 ? "oke le" : "gak terima ngutang le");
        }
    }
}
