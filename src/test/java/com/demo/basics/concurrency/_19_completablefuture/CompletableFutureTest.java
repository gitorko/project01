package com.demo.basics.concurrency._19_completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Completable Future - EASY]()
 *
 * - Non-blocking
 * - Ability to Programmatically completing a future
 * - Perform Error handling
 * - Ability to Chain several futures
 * - Ability to combine results of multiple futures (that run in parallel)
 * - Explicitly setting finished status.
 */
public class CompletableFutureTest {

    @Test
    public void test1() {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<CompletableFuture<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CompletableFuture<String> completableFuture = new CompletableFuture<>();
            futureList.add(completableFuture);
            executor.submit(() -> {
                CompletableFutureTest.doSomeProcessing(completableFuture);
            });
        }
        executor.shutdown();
    }

    @SneakyThrows
    public static void doSomeProcessing(CompletableFuture<String> completableFuture) {
        System.out.println("Running Thread: " + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        completableFuture.whenComplete(CompletableFutureTest::finishedRunningJob);
        completableFuture.complete("Completed Thread: " + Thread.currentThread().getName());
    }

    public static void finishedRunningJob(String result, Throwable t) {
        System.out.println("Got Result: " + result);
    }

    @SneakyThrows
    public void test2() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("thread: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Done!";
        });
        future.get();
    }

    @SneakyThrows
    @Test
    public void test3() {
        //With own thread pool
        Executor executor = Executors.newFixedThreadPool(1);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("thread: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Done!";
        }, executor);
        future.get();
    }


    @SneakyThrows
    @Test
    public void test4() {
        CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "John";
        }).thenApply(name -> {
            return "Hello " + name;
        }).thenApply(greeting -> {
            return greeting + ", Welcome to the Blog";
        });
        System.out.println(welcomeText.get());
    }

    //thenAccept
    @SneakyThrows
    @Test
    public void test5() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return "Chair";
        }).thenAccept(product -> {
            System.out.println("Got product detail for " + product);
        });
        future.get();
    }

    //thenRun
    @SneakyThrows
    @Test
    public void test6() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return "Chair";
        }).thenRun(() -> {
            System.out.println("Got product!");
        });
        future.get();
    }

    //thenAcceptAsync
    @SneakyThrows
    @Test
    public void test7() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return "Chair";
        }).thenAcceptAsync(product -> {
            System.out.println("Got product detail for " + product + " on thread: " + Thread.currentThread().getName());
        });
        future.get();
    }

    //Different thread
    @SneakyThrows
    @Test
    public void test8() {
        Executor executor = Executors.newFixedThreadPool(1);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return "Chair";
        }).thenAcceptAsync(product -> {
            System.out.println("Got product detail for " + product + " on thread: " + Thread.currentThread().getName());
        }, executor);
        future.get();
    }

}
