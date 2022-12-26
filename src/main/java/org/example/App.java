package org.example;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};
        int[] array2 = {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14};

        int[] newArray = resultArray(array);
        int[] newArray2 = resultArray(array2);
        int[] newArrayStream = resultArrayStream(array);
        int[] newArrayStream2 = resultArrayStream(array2);

        Arrays.stream(newArray)
                .forEach(System.out::println);
        Arrays.stream(newArray2)
                .forEach(System.out::println);
        Arrays.stream(newArrayStream)
                .forEach(System.out::println);
        Arrays.stream(newArrayStream2)
                .forEach(System.out::println);

    }

    public static int[] resultArrayStream(int[] array) {
        if ((array == null) || (array.length == 0)) {
            return new int[]{};
        }

        return Arrays.stream(array)
                .collect(() -> new int[2],
                        (arr, i) -> {
                    if(i > 0){
                        arr[0]++;
                    }else {
                        arr[1] += i;
                    }
                        },
                        (count, sum) -> {
                            count[0] = sum[0];
                            count[1] = sum[1];
                        });
    }

    public static int[] resultArray(int[] array) {
        int count = 0;
        int sum = 0;

        if ((array == null) || (array.length == 0)) {
            return new int[]{};
        }

        for (int j : array) {
            if (j > 0) {
                count++;
            } else {
                sum += j;
            }
        }

        return new int[]{count, sum};
    }
}
