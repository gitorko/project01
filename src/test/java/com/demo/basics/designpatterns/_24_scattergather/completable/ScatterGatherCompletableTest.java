package com.demo.basics.designpatterns._24_scattergather.completable;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class ScatterGatherCompletableTest {
    ExecutorService threadPool = Executors.newCachedThreadPool();

    @Test
    public void test() {
        Map<String, Float> book1Prices = new ScatterGatherCompletableTest().getPrices("book1");
        System.out.println(book1Prices);
    }

    @SneakyThrows
    private Map<String, Float> getPrices(String productId) {
        Map<String, Float> prices = new ConcurrentHashMap<>();

        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new FetchData("http://amazon", productId, prices));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new FetchData("http://ebay", productId, prices));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new FetchData("http://flipkart", productId, prices));

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1,task2,task3);
        try {
            allTasks.get(3, TimeUnit.SECONDS);
        } catch (TimeoutException ex) {
            //Do Nothing!
        }
        return prices;
    }

    @AllArgsConstructor
    class FetchData implements Runnable {

        String url;
        String productId;
        Map<String, Float> prices;

        @Override
        @SneakyThrows
        public void run() {
            if (url.contains("amazon")) {
                //http fetch from amazon
                System.out.println("Fetching price from amazon!");
                TimeUnit.SECONDS.sleep(2);
                prices.put("amazon", 2.35f);
            }

            if (url.contains("ebay")) {
                System.out.println("Fetching price from ebay!");
                //http fetch from ebay
                TimeUnit.SECONDS.sleep(4);
                prices.put("ebay", 2.30f);
            }

            if (url.contains("flipkart")) {
                System.out.println("Fetching price from flipkart!");
                //http fetch from flipkart
                TimeUnit.SECONDS.sleep(1);
                prices.put("flipkart", 2.10f);
            }
        }
    }
}

