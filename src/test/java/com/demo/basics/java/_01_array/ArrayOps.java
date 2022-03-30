package com.demo.basics.java._01_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class ArrayOps {

    @Test
    public void test_removeDuplicates() {
        List<Integer> listWithDuplicates = Arrays.asList(1, 1, 2, 2, 3, 3);
        List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listWithoutDuplicates);
    }

    @Test
    public void test_shuffleArray() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Collections.shuffle(intList);
        System.out.println(Arrays.toString(intList.toArray()));
    }

    @Test
    public void test_reverseArray() {
        List<String> arr = Arrays.asList("A", "B", "C");
        Collections.reverse(arr);
        System.out.println(arr);
    }

    @Test
    public void test_listToPrimitiveArray() {
        List<Integer> intList = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        int resultArr[] = intList.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(resultArr));
    }

    @Test
    public void test_listToIntArray() {
        List<Integer> nums = IntStream.range(0, 10).boxed().collect(Collectors.toList());

        Integer[] result1 = nums.toArray(new Integer[nums.size()]);
        System.out.println(Arrays.toString(result1));

        Integer[] result2 = nums.toArray(new Integer[0]);
        System.out.println(Arrays.toString(result2));
    }

    @Test
    public void test_arrToList() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> resultList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(resultList);
    }

    @Test
    public void test_print2dArray() {
        int matrix[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int expected[][] = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        System.out.println(Arrays.deepToString(matrix));
    }


    @Test
    public void test_listPrimitiveToarray() {
        List<int[]> arr = Arrays.asList(new int[]{1, 1}, new int[]{2, 2});
        int[][] ints = arr.toArray(new int[arr.size()][]);
        System.out.println(Arrays.deepToString(ints));
    }

    @Test
    public void test_partition() {
        List<Integer> intList = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        Map<Boolean, List<Integer>> groups = intList.stream().collect(Collectors.partitioningBy(s -> s % 2 == 0));
        List<List<Integer>> subSets = new ArrayList<>(groups.values());
        System.out.println(subSets.get(0));
        System.out.println(subSets.get(1));
    }

    @Test
    public void test_convertArray2dtoList() {
        String[][] accounts = {{"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"John", "johnsmith@mail.com", "john00@mail.com"}, {"Mary", "mary@mail.com"}, {"John", "johnnybravo@mail.com"}};
        List<List<String>> accountsList = Arrays.stream(accounts)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        System.out.println(accountsList);

        Integer[][] input = {{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {3, 1, 2}, {1, 3, 1, 1}};
        List<List<Integer>> result = Arrays.stream(input).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void test_copyPartofArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> result = Arrays.stream(arr, 5, 6).boxed().collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void test_getMaxAndSum() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int max = Arrays.stream(arr)
                .max()
                .getAsInt();
        System.out.println(max);

        int sum = Arrays.stream(arr)
                .sum();
        System.out.println(sum);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(Collections.max(nums));
        System.out.println(nums.stream().reduce(0, (x, y) -> x + y));
    }

    @Test
    public void test_convertArrayToSet() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        System.out.println(nums);
    }

}
