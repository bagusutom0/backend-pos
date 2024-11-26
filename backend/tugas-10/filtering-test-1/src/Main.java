import java.util.*;

public class Main {
    public static void main(String[] args) {
//        soal 1
//        hitungChar(new char[] {'a','b','c','b','b','c'});

//        soal 2
//        patternA(4);
        patternB(5);
    }

    private static void patternB(int n) {
        System.out.println("2b:");
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += i;
        }

//        for (int i = 0;  i<count ; i++) {
//            for (int j = 0; j < count; j++) {
//                for (int l = 0; l < n; l++) {
//                    for (int m = 0; m < l+1; m++) {
//                        if (i==j || i+j == (n-1)) {
//                            System.out.print(l+1);
//                        } else {
//                            System.out.print(" ");
//                        }
//                    }
//                }
//            }
//            System.out.println();
//        }

        char[][] charArray = new char[count][count];
        for (int x = 0; x < count; x++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i+1; j++) {
//                    charArray[i][j] = (char) ((i+1) + '0');
                    System.out.print(i+1);
                }
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {
                System.out.print(charArray[i][j]);
            }
            System.out.println();
        }
    }

    private static void patternA(int n) {
        System.out.println("Soal 2: ");
        System.out.println("2a:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(i+1);
            }
        }
        System.out.println();
    }

    private static void hitungChar(char[] chars) {
        System.out.println("Soal 1:");
        Set<Character> charSet = new HashSet<>();
        for (char e : chars) {
            charSet.add(e);
        }

        List charList = new ArrayList(charSet);
//        Collections.sort(charList);

        for (int i = 0; i < charList.size(); i++) {
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (charList.get(i).equals(chars[j])) {
                    count++;
                }
            }
            System.out.println(charList.get(i) + "," + count);
        }
    }
}