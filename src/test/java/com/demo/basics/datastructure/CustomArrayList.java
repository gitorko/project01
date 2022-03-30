package com.demo.basics.datastructure;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Implement ArrayList with array - EASY]()
 *
 * - use generics
 */
public class CustomArrayList {

    @Test
    public void test() {
        MyList<String> list = new MyList<>();
        for (int i = 0; i < 15; i++) {
            list.add("num_" + i);
        }
        for (int i = 0; i < 15; i++) {
            Assertions.assertEquals("num_" + i, list.get(i));
        }
    }

    class MyList<T> {
        int index = 0;
        int DEFAULT_CAPACITY = 10;
        Object[] arr = new Object[DEFAULT_CAPACITY];

        public void add(T element) {
            System.out.println("Adding: " + element);
            if (arr.length == index) {
                doubleSize();
            }
            arr[index++] = element;
        }

        public T get(int i) {
            if (i >= index || i < 0) {
                throw new IndexOutOfBoundsException("Out of bounds!");
            }
            return (T) arr[i];
        }

        public void remove(int i) {
            if (i >= index || i < 0) {
                throw new IndexOutOfBoundsException("Out of bounds!");
            }
            System.out.println("Object getting removed:" + arr[i]);
            for (int x = i; x < arr.length - 1; x++) {
                arr[x] = arr[x + 1];
            }
            index--;
        }

        /**
         * synchronized - to avoid 2 thread entering this critical function at same.
         * Double check locking - will be better here.
         */
        private synchronized void doubleSize() {
            System.out.println("Doubling size!");
            int newSize = arr.length * 2;
            arr = Arrays.copyOf(arr, newSize);
        }
    }
}


