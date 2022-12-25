package org.example;


import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.teeing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingInt;

public class App {
    public static void main( String[] args ) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};
        Integer[] arrayForTeeing = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};

        int[] newArray = resultArray(array);
        int[] newArrayStreamWithTeeing = resultArrayStreamWithTeeing(arrayForTeeing);
        int[] newArrayStream = resultArrayStream(array);

        Arrays.stream(newArray)
                .forEach(System.out::println);
        Arrays.stream(newArrayStreamWithTeeing)
                .forEach(System.out::println);
        Arrays.stream(newArrayStream)
                .forEach(System.out::println);
    }

    public static int[] resultArrayStreamWithTeeing(Integer[] array){
        if((array == null) || (array.length == 0)){
            return new int[]{};
        }

        return Stream.of(array)
                .collect(
                        teeing(
                                filtering(item -> item > 0, counting()),
                                filtering(item -> item < 0, summingInt(Integer::intValue)),
                                (count, sum) -> IntStream.of(count.intValue(), sum).toArray()
                        )
                );
    }

    public static int[] resultArrayStream(int[] array){
        if((array == null) || (array.length == 0)){
            return new int[]{};
        }

        AtomicInteger positiveCount = new AtomicInteger();
        AtomicInteger negativeSum = new AtomicInteger();
        Arrays.stream(array)
                .map(i -> i > 0 ? positiveCount.incrementAndGet() : negativeSum.getAndAdd(i))
                .toArray();

        return new int[]{positiveCount.intValue(), negativeSum.intValue()};
    }

    public static int[] resultArray(int[] array){
        int count = 0;
        int sum = 0;

        if((array == null) || (array.length == 0)){
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
