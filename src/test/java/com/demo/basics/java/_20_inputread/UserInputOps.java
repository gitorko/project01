package com.demo.basics.java._20_inputread;

import java.util.Arrays;
import java.util.Scanner;

public class UserInputOps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\,");
        int size = input.length;
        int [] arr = new int [size];
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        scanner.close();
        System.out.println(Arrays.stream(arr).toArray());
    }
}
