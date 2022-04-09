package com.demo.basics.java._21_guava.eventbus.async;

import com.demo.basics.java._21_guava.eventbus.sync.CustomEvent;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

public class AsyncEventListener {

    private static int eventsHandled;

    @Subscribe
    @AllowConcurrentEvents
    public void handleMessage(CustomEvent customEvent) throws InterruptedException {
        System.out.println(customEvent.getAction());
        Thread.sleep(5000);
        eventsHandled++;
    }
}
