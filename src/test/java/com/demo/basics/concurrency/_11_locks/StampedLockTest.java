package com.demo.basics.concurrency._11_locks;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Stamped Lock - MEDIUM]()
 *
 * - stamp lock
 */
public class StampedLockTest {

    String currTime = "";

    @SneakyThrows
    @Test
    public void test() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ReadWriteTask task = new ReadWriteTask(new StampedLock());

        executor.execute(task::readResourceOptimistic);
        executor.execute(task::writeResource);
        TimeUnit.SECONDS.sleep(2);
        executor.execute(task::readResource);
        executor.execute(task::readResource);
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    /**
     * Supports both read and write locks.
     * Lock acquisition methods return a stamp that is used to release a lock or to check if the lock is still valid
     * Another feature provided by StampedLock is optimistic locking
     */
    @AllArgsConstructor
    class ReadWriteTask {

        StampedLock lock;

        void readResource() {
            long stamp = lock.writeLock();
            try {
                System.out.println("currTime: " + currTime);
            } finally {
                lock.unlockWrite(stamp);
            }
        }

        @SneakyThrows
        void readResourceOptimistic() {
            long stamp = lock.tryOptimisticRead();
            System.out.println("currTime: " + currTime);
            //do some op long enough for value to change
            TimeUnit.SECONDS.sleep(2);
            if (lock.validate(stamp)) {
                try {
                    //acquire lock again
                    stamp = lock.readLock();
                    System.out.println("currTime: " + currTime);
                } finally {
                    lock.unlock(stamp);
                }
            } else {
                System.out.println("Lock stamp invalid!");
            }
        }

        void writeResource() {
            long stamp = lock.readLock();
            try {
                currTime = LocalDateTime.now().toString();
            } finally {
                lock.unlockRead(stamp);
            }
        }
    }
}
