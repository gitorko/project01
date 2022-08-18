package com.demo.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlgoUtil {
    public static List<List<Integer>> twoDArrayToList(int[][] twoDArray) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] arr : twoDArray) {
            List<Integer> collect = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toList());
            list.add(collect);
        }
        return list;
    }
}
