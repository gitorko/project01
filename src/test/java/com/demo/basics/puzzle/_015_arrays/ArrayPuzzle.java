package com.demo.basics.puzzle._015_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
 * https://www.youtube.com/watch?v=w6hhjg_gt_M&ab_channel=Devoxx
 */
public class ArrayPuzzle {

    @Test
    public void test() throws InterruptedException {
        String[] stringArray = {"one", "two", "three"};
        var stringList = Arrays.asList(stringArray);

        int[] intArray = {1, 2, 3};
        var intList = Arrays.asList(intArray);
        System.out.println(stringList.contains("one") + " , " + intList.contains(1));
    }

    @Test
    public void test2() throws InterruptedException {
        var ints = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        var sublist = ints.subList(0, 0);
        System.out.println(sublist);
        sublist.addAll(List.of(11, 12, 13));
        System.out.println(ints);
    }

    @Test
    public void test3() throws InterruptedException {
        try {
            String[] ints = {"a", "b", "c", null};
            var string1 = Stream.of(ints).toList();
            var string2 = List.of(ints);
            System.out.println(string1.size());
            System.out.println(string2.size());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void test4() throws InterruptedException {
        String[] ints = {"a", "b", "c", null};
        List<String> strings = Arrays.asList(ints);
        //strings.removeIf(Objects::isNull);
        System.out.println(strings.size());
    }
}
