package com.demo.basics.java._02_arraycopy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.ArrayUtils;
import org.junit.jupiter.api.Test;

public class ArrayCopyOps {

    @Test
    public void test3() {
        Integer[] a = {1, 2, 3};
        Integer[] b = {4, 5, 6};

        Object[] c1 = Stream.of(a, b)
                .flatMap(Stream::of)
                .toArray();

        Object[] c2 = Stream.of(a, b)
                .flatMap(Arrays::stream)
                .toArray();

        Object[] c3 = Stream.concat(Arrays.stream(a), Arrays.stream(b))
                .toArray();
        System.out.println(Arrays.toString(c3));
    }

    @Test
    public void test4() {
        int[][] arr = {{1, 2, 3}, {1, 2, 3, 4, 5}, {1}, {1, 2}};
        System.out.println(ArrayUtils.toString(arr));
        System.out.println(Arrays.deepToString(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    @Test
    public void test5() {
        int[] arr3 = {1, 2, 3, 4, 5};
        Arrays.stream(arr3).forEach(System.out::println);
    }

    @Test
    public void test6() {
        int[] arr2 = new int[5];
        Arrays.fill(arr2, 1);
        System.out.println(Arrays.toString(arr2));
    }

    @Test
    public void test7() {
        List<String> arrLst = Arrays.asList("a", "b", "c", "d");
        int midIndex = (arrLst.size() - 1) / 2;
        List<List<String>> lists = new ArrayList<>(
                arrLst.stream()
                        .collect(Collectors.partitioningBy(s -> arrLst.indexOf(s) > midIndex))
                        .values());
        System.out.println(lists.get(0));
        System.out.println(lists.get(1));
        List<List<String>> lists2 = new ArrayList<>(
                arrLst.stream()
                        .collect(Collectors.groupingBy(s -> arrLst.indexOf(s) > midIndex))
                        .values());
        System.out.println(lists2.get(0));
        System.out.println(lists2.get(1));
    }

    @Test
    public void test8() {
        List<String> arrLst = Arrays.asList("a", "b", "c", "d");
        int midIndex = (arrLst.size() - 1) / 2;
        List<String> first = new ArrayList<>(arrLst.subList(0, midIndex + 1));
        List<String> second = new ArrayList<>(arrLst.subList(midIndex + 1, arrLst.size()));
        System.out.println(first);
        System.out.println(second);
    }

    public void test9() {
        Integer[] source = {1, 2, 3, 4, 5};
        // Clone
        Integer[] dest1 = source.clone();
        if (Arrays.equals(source, dest1)) {
            System.out.println("Copied successfully: " + Arrays.toString(dest1));
        }

        // System array copy
        Integer[] dest2 = new Integer[source.length];
        System.arraycopy(source, 0, dest2, 0, source.length);
        if (Arrays.equals(source, dest2)) {
            System.out.println("Copied successfully: " + Arrays.toString(dest2));
        }

        // Array copy
        Integer[] dest3 = Arrays.copyOf(source, source.length);
        if (Arrays.equals(source, dest3)) {
            System.out.println("Copied successfully: " + Arrays.toString(dest3));
        }

        // Array copy of range - split array - can be used to split array
        Integer[] dest4 = Arrays.copyOfRange(source, 0, source.length);
        if (Arrays.equals(source, dest4)) {
            System.out.println("Copied successfully: " + Arrays.toString(dest4));
        }
        System.out.println();
    }

}
