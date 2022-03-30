package com.demo.basics.concurrency._20_atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import com.demo.common.Employee;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [AtomicReference - MEDIUM]()
 *
 * - AtomicReference
 */
public class AtomicRefTest {

    AtomicReference<Employee> cache = new AtomicReference<>();

    @SneakyThrows
    @Test
    public void test() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Employee emp = new Employee("John", 20);
        cache.set(emp);
        CountDownLatch latch = new CountDownLatch(2);

        executor.execute(() -> {
            for (int i = 1; i <= 3; i++) {
                Employee empObj = cache.get();
                cache.set(new Employee(empObj.getName(), empObj.getAge() + 10));
                System.out.println(cache.get().age);
            }
            latch.countDown();
        });
        executor.execute(() -> {
            for (int i = 1; i <= 3; i++) {
                Employee empObj = cache.get();
                cache.compareAndSet(empObj, new Employee("Jack", empObj.age + 10));
                System.out.println(cache.get().age);
            }
            latch.countDown();
        });
        latch.await();
        System.out.println("Final value: " + cache.get().age);
    }
}
