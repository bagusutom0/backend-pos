import java.util.Scanner;

public class SimulasiCustomException {
    public SimulasiCustomException() throws BukanUangException {
        System.out.println("Harga botol tupperware emak: 10000, cuma bisa beli 1 le");
        System.out.print("Masukan uang: ");
        int duit = 0;
        try {
            duit = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            throw new BukanUangException("Yang bener lah, masukin angka le");
        } finally {
            System.out.println(duit >= 5000 ? "oke le" : "gak terima ngutang le");
        }
    }
}
