package com.demo.basics.java._21_guava.eventbus.async;

import java.util.concurrent.Executors;

import com.demo.basics.java._21_guava.eventbus.sync.CustomEvent;
import com.demo.basics.java._21_guava.eventbus.sync.SyncEventListener;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

public class AsyncEventBusMain {

    public static void main(String[] args) {

        //Executors.newCachedThreadPool()
        EventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(5));
        SyncEventListener listener = new SyncEventListener();
        eventBus.register(listener);
        for (int i = 0; i < 500; i++) {
            CustomEvent customEvent = new CustomEvent("EVENT:" + i);
            eventBus.post(customEvent);
            System.out.println("Posted " + i);
        }
    }

}
