package com.demo.basics.java._21_guava.eventbus.sync;

public class CustomEvent {

    private String action;

    public CustomEvent(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
