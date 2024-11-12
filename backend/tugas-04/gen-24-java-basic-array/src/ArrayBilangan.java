import java.util.Arrays;

public class ArrayBilangan {
    int[] numbers = {1,2,3,4,5,6,6};

    void arraySum() {
        int counter = 0;
        for (int number : numbers) {
            counter += number;
        }

        System.out.println(counter);
    }

    int[] arraySumEachRow(int[][] array2d) {
        int[] result = new int[array2d.length];
        for (int i = 0; i < result.length; i++) {
            int counter = 0;
            for (int j = 0; j < array2d[i].length; j++) {
                counter += array2d[i][j];
            }
            result[i] = counter;
        }

        return result;
    }

    void reverseArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = arr.length -1, j = 0; i > -1 && j < arr.length; i--, j++) {
            result[j] = arr[i];
        }

        System.out.println(Arrays.toString(result));
    }
}
