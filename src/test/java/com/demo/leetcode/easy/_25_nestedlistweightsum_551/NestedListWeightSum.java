package com.demo.leetcode.easy._25_nestedlistweightsum_551;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [339. Nested List Weight Sum - EASY ](https://leetcode.com/problems/nested-list-weight-sum/)
 * https://www.lintcode.com/problem/551/
 *
 *  - use level
 *
 * https://www.youtube.com/watch?v=B2i_AfmZBgk&ab_channel=LCBear
 */
public class NestedListWeightSum {

    @Test
    public void test1() {
        NestedInteger l1 = NestedInteger.builder()
                .values(Arrays.asList(1, 1))
                .build();
        NestedInteger l2 = NestedInteger.builder()
                .val(2)
                .build();
        NestedInteger l3 = NestedInteger.builder()
                .values(Arrays.asList(1, 1))
                .build();

        List<NestedInteger> input = Arrays.asList(l1, l2, l3);
        Assertions.assertEquals(10, depthSum(input));
    }

    @Test
    public void test2() {
        NestedInteger l6 = NestedInteger.builder()
                .val(6)
                .build();
        NestedInteger l4 = NestedInteger.builder()
                .val(4)
                .values(Arrays.asList(l6))
                .build();
        NestedInteger l1 = NestedInteger.builder()
                .val(1)
                .build();
        List<NestedInteger> input = Arrays.asList(l1, l4);
        System.out.println(input);
        Assertions.assertEquals(27, depthSum(input));
    }

    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        int level = 1;
        while (nestedList.size() != 0) {
            List<NestedInteger> tmp = new ArrayList<>();
            for (NestedInteger e : nestedList) {
                if (e.isInteger()) {
                    sum += e.getInteger() * level;
                } else {
                    tmp.addAll(e.getList());
                }
            }
            level++;
            nestedList = tmp;
        }
        return sum;
    }
}

@Builder
class NestedInteger {

    @Builder.Default
    List<Object> values = new ArrayList<>();
    Integer val;

    public boolean isInteger() {
        return val != null && values.size() == 0;
    }

    public Integer getInteger() {
        if (isInteger()) {
            return val;
        }
        return null;
    }

    public List<NestedInteger> getList() {
        List<NestedInteger> result = new ArrayList<>();

        if (val != null) {
            result.add(NestedInteger.builder()
                    .val(val)
                    .build());
        }
        if (val != null && values != null) {
            result.add(NestedInteger.builder()
                    .values(values)
                    .build());
        } else if (val == null && values != null) {
            for (Object node : values) {
                if (node instanceof NestedInteger) {
                    result.add((NestedInteger) node);
                }
                if (node instanceof Integer) {
                    result.add(NestedInteger.builder()
                            .val((Integer) node)
                            .build());
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "NestedInteger{" +
                "values=" + values +
                ", val=" + val +
                '}';
    }
}
