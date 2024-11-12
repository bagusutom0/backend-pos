public class Tugas {
    String name = "Bagus";
    String domisili = "Tangerang";

    void arithmetic() {
        System.out.println("Hasil dari 138473 / 3432 adalah " + (138473 / 3432));
    }

    void triangle() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j < i+1)
                    System.out.print("*");
            }
            System.out.println("\n");
        }
    }

    void sumEvenOdd(int a, int b) {
        if (a > 0 && b > 0)
            System.out.println((a + b) % 2 == 0 ? "genap" : "ganjil");
    }
}
