package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
    private int[] actual;
    private int[] actual_2;

    @BeforeEach
    public void prepareData() {
        actual = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};
        actual_2 = new int[]{0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14};
    }

    @Test
    void resultArrayStreamWithReduce() {
        int[] expectedResult = App.resultArrayWithReduce(actual);
        int[] expectedResult2 = App.resultArrayWithReduce(actual_2);
        Assertions.assertArrayEquals(expectedResult, new int[]{10, -65});
        Assertions.assertArrayEquals(expectedResult2, new int[]{8, -50});
    }

    @Test
    void resultArrayStream() {
        int[] expectedResult = App.resultArrayStream(actual);
        int[] expectedResult2 = App.resultArrayStream(actual_2);
        Assertions.assertArrayEquals(expectedResult, new int[]{10, -65});
        Assertions.assertArrayEquals(expectedResult2, new int[]{8, -50});
    }

    @Test
    void resultArray() {
        int[] expectedResult = App.resultArrayStream(actual);
        int[] expectedResult2 = App.resultArrayStream(actual_2);
        Assertions.assertArrayEquals(expectedResult, new int[]{10, -65});
        Assertions.assertArrayEquals(expectedResult2, new int[]{8, -50});
    }
}
