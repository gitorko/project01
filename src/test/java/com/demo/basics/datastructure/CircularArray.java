package com.demo.basics.datastructure;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Implement Circular Array - EASY]()
 *
 * - last = (last + 1) % arraySize;
 */
public class CircularArray {

    @Test
    public void test() {
        CustomArray ca = new CustomArray(5);
        int expected[] = {6, 7, 8, 9, 10};
        IntStream.rangeClosed(1, 10).forEach(e -> {
            ca.add(e);
        });
        Assertions.assertArrayEquals(expected, ca.array);
        Arrays.stream(ca.array).forEach(System.out::println);
    }

    class CustomArray {
        int[] array;
        int last = 0;
        int arraySize;

        public CustomArray(Integer size) {
            this.arraySize = size;
            this.array = new int[size];
        }

        public void add(Integer ele) {
            array[last] = ele;
            last = (last + 1) % arraySize;
        }
    }

}
