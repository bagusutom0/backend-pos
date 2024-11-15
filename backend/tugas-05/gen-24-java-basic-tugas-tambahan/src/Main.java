import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        pola1(range);
        pola2(range);
        pola3(range);
    }

    private static void pola1(int range) {
        System.out.println("Pola 1");
        int count = 65;
        for (int i = 1; i <= range; i++) {
            for (int j = 1; j <= range; j++) {
                if (j <= (range/2)) {
                    System.out.print((char)count++);
                } else {
                    System.out.print((char)count--);
                }
            }
            count = 65;
            System.out.println();
        }
        System.out.println();
    }

    private static void pola2(int range) {
        System.out.println("Pola 2");
        int countChar = 65;
        for (int i = 1; i <= range; i++) {
            for (int j = 1; j <= range; j++) {
                if (j <= (range/2)) {
                    if (i == j || i+j == range+1) {
                        System.out.print((char)countChar);
                    } else {
                        System.out.print(" ");
                    }
                    countChar++;
                } else {
                    if (i == j || i+j == range+1) {
                        System.out.print((char)countChar);
                    } else {
                        System.out.print(" ");
                    }
                    countChar--;
                }
            }
            countChar = 65;
            System.out.println();
        }
        System.out.println();
    }

    private static void pola3(int range) {
        System.out.println("Pola 3");
        int countChar = 65;
        for (int i = 1; i <= range; i++) {
            for (int j = 1; j <= range; j++) {
                if (j <= (range/2)) {
                    if (i == j || i+j == range+1 || i == (range/2)+1) {
                        System.out.print((char)countChar);
                    } else {
                        System.out.print(" ");
                    }
                    countChar++;
                } else {
                    if (i == j || i+j == range+1 || i == (range/2)+1) {
                        System.out.print((char)countChar);
                    } else {
                        System.out.print(" ");
                    }
                    countChar--;
                }
            }
            countChar = 65;
            System.out.println();
        }
        System.out.println();
    }
}