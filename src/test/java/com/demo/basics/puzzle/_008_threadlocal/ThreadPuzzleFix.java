package com.demo.basics.puzzle._008_threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

public class ThreadPuzzleFix {

    public static ThreadLocal<SimpleDateFormat> df =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("dd/MM/yyyy"));

    @Test
    public void test() {
        List<String> joinDates = Arrays.asList("01/01/2015",
                "01/01/2016",
                "01/01/2017",
                "01/01/2018",
                "01/01/2019"
        );
        CountDownLatch latch = new CountDownLatch(joinDates.size());
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String doj : joinDates) {
            executor.execute(() -> {
                try {
                    SimpleDateFormat localDf = ThreadPuzzleFix.df.get();
                    System.out.println(localDf.parse(doj));
                } catch (ParseException e) {
                    //e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
