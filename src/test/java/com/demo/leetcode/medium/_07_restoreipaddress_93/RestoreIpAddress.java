package com.demo.leetcode.medium._07_restoreipaddress_93;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [93. Restore IP Addresses - MEDIUM](https://leetcode.com/problems/restore-ip-addresses/)
 *
 * - backtracking
 * - out of bound, 0 check, 255 check
 *
 * https://www.youtube.com/watch?v=61tN4YEdiTM&ab_channel=NeetCode
 */
public class RestoreIpAddress {

    @Test
    public void test() {
        List<String> expected = Arrays.asList("255.255.11.135", "255.255.111.35");
        Assertions.assertEquals(expected, restoreIpAddresses("25525511135"));
    }

    /**
     * Time: O(3^4)
     * Space: O(1)
     */
    List<String> result;
    String ipStr;

    public List<String> restoreIpAddresses(String s) {
        ipStr = s;
        result = new ArrayList<>();
        dfs(0, new ArrayList<>());
        return result;
    }

    private void dfs(int start, List<String> temp) {
        //temp hold 4 sub ip, start is same length as input.
        if (temp.size() == 4 && start == ipStr.length()) {
            result.add(String.join(".", temp));
            return;
        }
        //temp hold 4 single digit or start is at the end.
        if (temp.size() == 4 || start == ipStr.length())
            return;

        for (int length = 1; length < 4; length++) {
            int newStart = start + length;
            // out of bound
            if (newStart > ipStr.length())
                return;
            // leading '0'
            if (length > 1 && ipStr.charAt(start) == '0')
                return;
            String num = ipStr.substring(start, newStart);
            //beyond 255 check
            if (Integer.parseInt(num) > 255)
                return;
            temp.add(num);
            dfs(newStart, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
