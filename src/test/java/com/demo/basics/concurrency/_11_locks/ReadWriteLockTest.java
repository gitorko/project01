package com.demo.basics.concurrency._11_locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Read Write lock - MEDIUM]()
 *
 * - read vs write lock
 */
public class ReadWriteLockTest {

    @SneakyThrows
    @Test
    public void test() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock rLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock wLock = lock.writeLock();
        ReadWriteTask task = new ReadWriteTask(rLock, wLock);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(task::writeResource);
        TimeUnit.SECONDS.sleep(2);
        executor.execute(task::readResource);
        executor.execute(task::readResource);
        executor.shutdown();
        executor.awaitTermination(25, TimeUnit.SECONDS);
    }

    /**
     * readLock.lock();
     * This means that if any other thread is writing (i.e. holds a write lock) then stop here until no other thread is writing.
     * Once the lock is granted no other thread will be allowed to write (i.e. take a write lock) until the lock is released.
     *
     * writeLock.lock();
     * This means that if any other thread is reading or writing, stop here and wait until no other thread is reading or writing.
     * Once the lock is granted, no other thread will be allowed to read or write (i.e. take a read or write lock) until the lock is released.
     */
    @AllArgsConstructor
    class ReadWriteTask {

        ReentrantReadWriteLock.ReadLock rLock;
        ReentrantReadWriteLock.WriteLock wLock;

        void readResource() {
            System.out.println(Thread.currentThread().getName() + " Requesting Reading!");
            rLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " Acquired read lock!");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " Released read lock!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rLock.unlock();
            }

        }

        void writeResource() {
            System.out.println(Thread.currentThread().getName() + " Requesting Writing!");
            wLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " Acquired write lock!");
                TimeUnit.SECONDS.sleep(15);
                System.out.println(Thread.currentThread().getName() + " Releasing write lock!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                wLock.unlock();
            }
        }
    }
}


