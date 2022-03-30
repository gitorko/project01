package com.demo.basics.concurrency._20_atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

import com.demo.common.Employee;
import org.junit.jupiter.api.Test;

/**
 * [AtomicStampedReference - MEDIUM]()
 *
 * - AtomicStampedReference
 */
public class AtomicRefStampTest {

    AtomicInteger stampVal = new AtomicInteger();
    AtomicStampedReference<Employee> cache = new AtomicStampedReference<>(new Employee("John", 20), stampVal.get());
    CountDownLatch latch = new CountDownLatch(2);

    @Test
    public void test() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Employee emp = new Employee("John", 20);
        cache.set(emp, stampVal.get());
        executor.execute(() -> {
            for (int i = 1; i <= 3; i++) {
                Employee empObj = cache.getReference();
                cache.set(new Employee(empObj.getName(), empObj.getAge() + 10), stampVal.incrementAndGet());
                System.out.println(cache.getReference().age);
            }
            latch.countDown();
        });
        executor.execute(() -> {
            for (int i = 1; i <= 3; i++) {
                Employee empObj = cache.getReference();
                cache.compareAndSet(empObj, new Employee("Jack", empObj.age + 10), stampVal.get(), stampVal.incrementAndGet());
                System.out.println(cache.getReference().age);
            }
            latch.countDown();
        });
        System.out.println("Final value: " + cache.getReference().age);
    }

}
