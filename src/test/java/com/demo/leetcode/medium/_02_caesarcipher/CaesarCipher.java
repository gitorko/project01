package com.demo.leetcode.medium._02_caesarcipher;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Caesar Cipher - MEDIUM]()
 *
 * - rotation cipher
 */
public class CaesarCipher {

    @Test
    public void test() {
        Assertions.assertEquals("Cheud-726?", rotationalCipher("Zebra-493?", 3));
        Assertions.assertEquals("nopqrstuvwxyzABCDEFGHIJKLM9012345678", rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39));
    }

    public String rotationalCipher(String input, int rotationFactor) {
        char[] nums = "0123456789".toCharArray();
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        char[] numRotated = rotate(nums, rotationFactor);
        char[] lettersRotated = rotate(letters, rotationFactor);

        //map rotated char to base index
        Map<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < lettersRotated.length; i++) {
            charMap.put(lettersRotated[i], letters[i]);
        }

        //map rotated num to base index
        Map<Character, Character> numMap = new HashMap<>();
        for (int i = 0; i < numRotated.length; i++) {
            numMap.put(numRotated[i], nums[i]);
        }

        char[] result = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                if (Character.isLowerCase(input.charAt(i))) {
                    result[i] = charMap.get(input.charAt(i));
                } else {
                    result[i] = Character.toUpperCase(charMap.get(Character.toLowerCase(input.charAt(i))));
                }
            } else if (Character.isDigit(input.charAt(i))) {
                result[i] = numMap.get(input.charAt(i));
            } else {
                result[i] = input.charAt(i);
            }
        }
        return String.valueOf(result);
    }

    private char[] rotate(char[] input, int k) {
        char[] a = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            a[(i + k) % input.length] = input[i];
        }
        return a;
    }
}
