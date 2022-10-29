package com.demo.basics.puzzle._015_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class ArrayPuzzleFix {

    @Test
    public void test1() throws InterruptedException {
        String[] stringArray = {"one", "two", "three"};
        var stringList = Arrays.asList(stringArray);

        int[] intArray = {1, 2, 3};
        var intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        System.out.println(stringList.contains("one") + " , " + intList.contains(1));
    }

    @Test
    public void test2() throws InterruptedException {
        var ints = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        var sublist = new ArrayList<>(ints.subList(0, 0));
        System.out.println(sublist);
        sublist.addAll(List.of(11, 12, 13));
        System.out.println(ints);
    }



}
