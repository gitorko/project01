package com.demo.basics.java._04_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.Iterables;
import org.junit.jupiter.api.Test;

public class SetOps {

    @Test
    public void test() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] array = new Integer[set.size()];

        int k = 0;
        for (Integer i : set) {
            array[k++] = i;
        }
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test1() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] array = set.toArray(new Integer[set.size()]);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        //pass an empty array of the specified type, and JVM will allocate the necessary memory
        Integer[] array = set.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test3() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] array = set.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));
    }


    @Test
    public void test4() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] array = Iterables.toArray(set, Integer.class);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test5() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        int[] primitive = set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(primitive));

        int[] primitive2 = set.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(primitive2));
    }

}
