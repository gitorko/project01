package com.demo.basics.java._21_guava.eventbus.sync;

import com.google.common.eventbus.EventBus;

public class SyncEventBusMain {

    public static void main(String[] args) {
        //producer

        EventBus eventBus = new EventBus();
        SyncEventListener listener = new SyncEventListener();
        eventBus.register(listener);
        for (int i = 0; i < 5; i++) {
            CustomEvent customEvent = new CustomEvent("EVENT:" + i);
            eventBus.post(customEvent);
            System.out.println("Posted " + i);
        }

    }
}
