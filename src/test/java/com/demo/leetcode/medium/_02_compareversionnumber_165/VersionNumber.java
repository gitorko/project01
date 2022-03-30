package com.demo.leetcode.medium._02_compareversionnumber_165;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [165. Compare Version Numbers - MEDIUM](https://leetcode.com/problems/compare-version-numbers/)
 *
 * - recursion
 */
public class VersionNumber {

    @Test
    public void test() {
        Assertions.assertEquals(0, compareVersion("1.01", "1.001"));
        Assertions.assertEquals(0, compareVersion("1.0", "1.0.0"));
        Assertions.assertEquals(-1, compareVersion("0.1", "1.1"));
        Assertions.assertEquals(1, compareVersion("1.0.1", "1"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(0, compareVersion2("1.01", "1.001"));
        Assertions.assertEquals(0, compareVersion2("1.0", "1.0.0"));
        Assertions.assertEquals(-1, compareVersion2("0.1", "1.1"));
        Assertions.assertEquals(1, compareVersion2("1.0.1", "1"));
    }

    /**
     * Iterative
     * Time: O(1)
     * Space: O(1)
     */
    public int compareVersion2(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");
        int length = Math.max(levels1.length, levels2.length);

        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0)
                return compare;
        }
        return 0;
    }

    /**
     * Recursion
     * Time: O(n)
     * Space: O(n)
     */
    public int compareVersion(String version1, String version2) {
        int index1 = version1.indexOf(".");
        int index2 = version2.indexOf(".");

        Integer v1 = Integer.parseInt(version1.substring(0, index1 == -1 ? version1.length() : index1));
        Integer v2 = Integer.parseInt(version2.substring(0, index2 == -1 ? version2.length() : index2));
        if (v1 > v2) {
            return 1;
        } else if (v1 < v2) {
            return -1;
        } else if (index1 == -1 && index2 == -1 && v1 == v2) {
            return 0;
        } else if (index1 == -1) {
            return compareVersion("0", version2.substring(index2 + 1));
        } else if (index2 == -1) {
            return compareVersion(version1.substring(index1 + 1), "0");
        } else {
            return compareVersion(version1.substring(index1 + 1), version2.substring(index2 + 1));
        }
    }
}

