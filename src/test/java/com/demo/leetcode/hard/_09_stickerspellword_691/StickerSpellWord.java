package com.demo.leetcode.hard._09_stickerspellword_691;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [691. Stickers to Spell Word - HARD](https://leetcode.com/problems/stickers-to-spell-word/)
 *
 * https://www.youtube.com/watch?v=hsomLb6mUdI&ab_channel=NeetCode
 */
public class StickerSpellWord {

    @Test
    public void test1() {
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";
        Assertions.assertEquals(3, minStickers(stickers, target));
    }

    @Test
    public void test2() {
        String[] stickers = {"a", "aa"};
        String target = "aa";
        Assertions.assertEquals(1, minStickers(stickers, target));
    }

    @Test
    public void test3() {
        String[] stickers = {"notice", "possible"};
        String target = "basicbasic";
        Assertions.assertEquals(-1, minStickers(stickers, target));
    }

    @Test
    public void test4() {
        String[] stickers = {"these", "guess", "about", "garden", "him"};
        String target = "atomher";
        Assertions.assertEquals(3, minStickers(stickers, target));
    }

    @Test
    public void test5() {
        String[] stickers = {"this", "island", "keep", "spring", "problem", "subject"};
        String target = "gasproper";
        Assertions.assertEquals(3, minStickers(stickers, target));
    }

    @Test
    public void test6() {
        String[] stickers = {"and", "pound", "force", "human", "fair", "back", "sign", "course", "sight", "world", "close", "saw", "best", "fill", "late", "silent", "open", "noon", "seat", "cell", "take", "between", "it", "hundred", "hat", "until", "either", "play", "triangle", "stay", "separate", "season", "tool", "direct", "part", "student", "path", "ear", "grow", "ago", "main", "was", "rule", "element", "thing", "place", "common", "led", "support", "mean"};
        String target = "quietchord";
        Assertions.assertEquals(-1, minStickers(stickers, target));
    }

    @Test
    public void test7() {
        String[] stickers = {"wear", "oh", "wheel", "famous", "observe", "dictionary", "bought", "salt", "stop", "pretty", "result", "hour", "great", "me", "dollar", "valley", "bear", "table", "slow", "before", "fall", "kept", "charge", "excite", "page", "degree", "present", "talk", "help", "held", "happy", "and", "hope", "beauty", "be", "stead", "car", "now", "them", "trip", "season", "condition", "excite", "history", "page", "again", "silver"};
        String target = "nmgoodlodlzt";
        Assertions.assertEquals(-1, minStickers(stickers, target));
    }

    /**
     * Time: O(n * 2^n)
     * Space: O(n*m) , n is stickers & m is length of char in stickers
     */
    int[][] stickerMap;
    //[string, min stickers required]
    Map<String, Integer> dp;

    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        stickerMap = new int[m][26];
        dp = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerMap[i][c - 'a']++;
            }
        }
        int result = dfs(target);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(String target) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        int result = Integer.MAX_VALUE;
        // try every sticker
        for (int i = 0; i < stickerMap.length; i++) {
            // optimization: doesn't contain the first char then skip
            // also ensure we pick a sticker that has some common char
            if (stickerMap[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }
            int[] stickerCopy = Arrays.copyOf(stickerMap[i], stickerMap[i].length);
            StringBuilder remainStr = new StringBuilder();
            for (int j = 0; j < target.length(); j++) {
                if (stickerCopy[target.charAt(j) - 'a'] > 0) {
                    stickerCopy[target.charAt(j) - 'a']--;
                } else {
                    remainStr.append(target.charAt(j));
                }
            }
            String remainTarget = remainStr.toString();
            //if empty then found result.
            if (remainTarget.isEmpty()) {
                return 1;
            } else {
                int usedStickers = dfs(remainTarget);
                //we don't want to do max + 1
                if (usedStickers < Integer.MAX_VALUE) {
                    result = Math.min(result, 1 + usedStickers);
                }
            }
        }
        dp.put(target, result);
        return dp.get(target);
    }
}
