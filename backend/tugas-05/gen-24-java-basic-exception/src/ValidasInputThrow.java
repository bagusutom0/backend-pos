import java.util.Scanner;

public class ValidasInputThrow {
    public ValidasInputThrow() {
        System.out.println("Harga bakso: 5500, cuma bisa beli 1 le");
        System.out.print("Masukan uang: ");
        int duit = 0;
        try {
            duit = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Yang bener lah, masukin angka le");
        } finally {
            System.out.println(duit >= 5000 ? "oke le" : "gak terima ngutang le");
        }
    }
}
