import java.util.*;

public class Main {
    public static void main(String[] args) {
//        function: input & tampilkan data barang
        List<String> dataBarang = inputDataBarang();

//        menampilkan salah satu data barang
        if (dataBarang.isEmpty()) {
            System.out.println("Data barang kosong");
        } else {
            System.out.println("Data barang yang pertama dimasukan adalah: " + dataBarang.get(0));
        }

//        konversi data barang ke jenis collection lain
        Set<String> setDataBarang = new HashSet<>();
        setDataBarang.addAll(dataBarang);
//        printout datanya
        System.out.println("Data barang yang dimasukan tanpa duplikasi adalah:" + setDataBarang);
    }

//    function: input dan tampilkan data barang (nama barang)
    static List<String> inputDataBarang() {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();

        String temp;
        while (true) {
            System.out.print("Masukan data barang atau selesai: ");
            temp = scanner.nextLine().trim().toLowerCase();
            if (temp.equals("selesai")) {
                break;
            } else {
                result.add(temp);
            }
        }

        System.out.println("Data barang yang telah dimasukan adalah " + result);
        return result;
    }

}