package com.demo.leetcode.medium._17_bathroomproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Bathroom Problem - MEDIUM]()
 *
 * - semaphore
 */
public class BathRoomProblem {
    /**
     * A bathroom is being designed for the use of both republican and democrat in an office.
     * But requires the following constraints to be maintained:
     * - There cannot be republican and democrat in the bathroom at the same time.
     * - There should never be more than x in the bathroom simultaneously.
     */

    @SneakyThrows
    @Test
    public void test1_moreThanPermit() {
        BathRoom bathRoom = new BathRoom(3);
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Callable<Void>> callables = new ArrayList<>();
        callables.add(() -> {
            bathRoom.enterDemocrat();
            return null;
        });
        callables.add(() -> {
            bathRoom.enterDemocrat();
            return null;
        });
        callables.add(() -> {
            bathRoom.enterDemocrat();
            return null;
        });
        callables.add(() -> {
            bathRoom.enterDemocrat();
            return null;
        });
        executor.invokeAll(callables, 10, TimeUnit.SECONDS);
    }

    @SneakyThrows
    @Test
    public void test2_mix() {
        BathRoom bathRoom = new BathRoom(3);
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Callable<Void>> callables = new ArrayList<>();
        callables.add(() -> {
            bathRoom.enterDemocrat();
            return null;
        });
        callables.add(() -> {
            bathRoom.enterRepublican();
            return null;
        });
        callables.add(() -> {
            bathRoom.enterDemocrat();
            return null;
        });
        callables.add(() -> {
            bathRoom.enterRepublican();
            return null;
        });
        callables.add(() -> {
            bathRoom.enterDemocrat();
            return null;
        });
        callables.add(() -> {
            bathRoom.enterRepublican();
            return null;
        });
        callables.add(() -> {
            bathRoom.enterDemocrat();
            return null;
        });
        callables.add(() -> {
            bathRoom.enterRepublican();
            return null;
        });
        executor.invokeAll(callables, 10, TimeUnit.SECONDS);
    }

    class BathRoom {
        Semaphore demAccess;
        Semaphore repAccess;
        Semaphore access;
        ReentrantLock lock;
        int permit;

        public BathRoom(int permit) {
            this.permit = permit;
            demAccess = new Semaphore(permit);
            repAccess = new Semaphore(permit);
            access = new Semaphore(1);
            lock = new ReentrantLock();
        }

        @SneakyThrows
        public void enterDemocrat() {
            while (true) {
                lock.lock();
                if (repAccess.availablePermits() == permit) {
                    demAccess.acquire();
                    lock.unlock();
                    useBathRoom("Democrat");
                    demAccess.release();
                    lock.lock();
                    if (demAccess.availablePermits() == permit && access.availablePermits() == 0) {
                        access.release();
                    }
                    lock.unlock();
                    return;
                } else {
                    System.out.println("Democrat waiting!");
                    lock.unlock();
                    access.acquire();
                }
            }
        }

        @SneakyThrows
        public void enterRepublican() {
            while (true) {
                lock.lock();
                if (demAccess.availablePermits() == permit) {
                    repAccess.acquire();
                    lock.unlock();
                    useBathRoom("Republican");
                    repAccess.release();
                    lock.lock();
                    if (repAccess.availablePermits() == permit && access.availablePermits() == 0) {
                        access.release();
                    }
                    lock.unlock();
                    return;
                } else {
                    System.out.println("Republican waiting!");
                    lock.unlock();
                    access.acquire();
                }
            }
        }

        @SneakyThrows
        private void useBathRoom(String person) {
            System.out.println(person + " using bathroom!");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(person + " finished using bathroom!");
        }
    }
}
