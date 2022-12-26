package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AppTest {


    @Test
    void resultArrayStream() {
        int[] actual = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};
        int[] actual2 = {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14};
        int[] expectedResult = App.resultArrayStream(actual);
        int[] expectedResult2 = App.resultArrayStream(actual2);
        Assertions.assertTrue(Arrays.equals(expectedResult, new int[]{10, -65}));
        Assertions.assertTrue(Arrays.equals(expectedResult2, new int[]{8, -50}));
    }

    @Test
    void resultArray() {
    }
}
