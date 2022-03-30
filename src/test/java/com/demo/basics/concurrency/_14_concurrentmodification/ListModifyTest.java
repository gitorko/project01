package com.demo.basics.concurrency._14_concurrentmodification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 * [Concurrent Modification - EASY]()
 *
 * - Fail Fast vs Fail Safe
 */
public class ListModifyTest {

    /**
     * https://www.javacodemonk.com/fail-safe-vs-fail-fast-iterator-in-java-collections-framework-501606c6
     * https://www.baeldung.com/java-concurrentmodificationexception
     */
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        try {
            IntStream.range(0, 5).forEach(i -> list.add(i));
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (i % 2 == 0) {
                    list.remove(i);
                }
            }
        } catch (Exception ex) {
            //java.util.ConcurrentModificationException
            System.out.println(ex.toString());
        }
        System.out.println("test1: " + list);
    }


    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        try {
            IntStream.range(0, 5).forEach(i -> list.add(i));
            for (Integer num : list) {
                if (num % 2 == 0) {
                    list.remove(num);
                }
            }
        } catch (Exception ex) {
            //java.util.ConcurrentModificationException
            System.out.println(ex.toString());
        }
        System.out.println("test2: " + list);
    }

    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>();
        try {
            IntStream.range(0, 5).forEach(i -> list.add(i));
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() % 2 == 0) {
                    it.remove();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        System.out.println("test3: " + list);
    }

    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>();
        try {
            IntStream.range(0, 5).forEach(i -> list.add(i));
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % 2 == 0) {
                    list.remove(list.get(i));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        System.out.println("test4: " + list);
    }

    @Test
    public void test5() {
        List<Integer> failSafeList = new CopyOnWriteArrayList<>();
        IntStream.range(0, 5).forEach(i -> failSafeList.add(i));
        for (Integer num : failSafeList) {
            if (num % 2 == 0) {
                failSafeList.remove(num);
            }
        }
        System.out.println("test5: " + failSafeList);
    }

    @Test
    public void test6() {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> list.add(i));
        list.removeIf(i -> i % 2 == 0);
        System.out.println("test6: " + list);
    }

}
