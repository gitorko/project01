package com.demo.basics.puzzle._016_string_pool;

import org.junit.jupiter.api.Test;

public class StringPoolPuzzle {

    @Test
    public void test() throws InterruptedException {
        String str1 = new String("Hello World");
        String str2 = new String("Hello World");
        System.out.println(str1 == str2);

        String str3 = "Hello World";
        String str4 = "Hello World";
        System.out.println(str3 == str4);

        String str5 = str1.intern();
        String str6 = str2.intern();
        System.out.println(str5 == str6);

        System.out.println(str5 == str3);
    }
}
