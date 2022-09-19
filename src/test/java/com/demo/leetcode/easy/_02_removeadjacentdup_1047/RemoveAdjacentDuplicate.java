package com.demo.leetcode.easy._02_removeadjacentdup_1047;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1047. Remove All Adjacent Duplicates In String - EASY](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)
 */
public class RemoveAdjacentDuplicate {

    @Test
    public void test1() {
        Assertions.assertEquals("ca", removeDuplicates("abbaca"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals("ay", removeDuplicates("azxxzy"));
    }

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
