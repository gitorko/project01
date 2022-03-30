package com.demo.basics.java._21_guava.eventbus.sync;

import com.google.common.eventbus.Subscribe;

public class SyncEventListener {

    private static int eventsHandled;

    @Subscribe
    public void handleMessage(CustomEvent customEvent) throws InterruptedException {
        System.out.println(customEvent.getAction());
        Thread.sleep(60000);
        eventsHandled++;
    }
}
