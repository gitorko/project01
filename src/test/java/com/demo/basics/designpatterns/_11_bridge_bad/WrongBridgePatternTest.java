package com.demo.basics.designpatterns._11_bridge_bad;

import org.junit.jupiter.api.Test;

public class WrongBridgePatternTest {

    @Test
    public void test() {
        PullSwitch switch1 = new PullSwitchFan();
        PressSwitch switch2 = new PressSwitchLight();
        switch1.toggle();
        switch2.toggle();
    }
}

abstract class Switch {
    abstract public void toggle();
}

abstract class PullSwitch extends Switch {
}

abstract class PressSwitch extends Switch {
}

class PullSwitchFan extends PullSwitch {

    boolean state;

    @Override
    public void toggle() {
        if (state) {
            System.out.println("Pulled Switch, Now turning off fan");
            state = Boolean.FALSE;
        } else {
            System.out.println("Pulled Switch, Now turning on fan");
            state = Boolean.TRUE;
        }
    }
}

class PullSwitchLight extends PullSwitch {

    boolean state;

    @Override
    public void toggle() {
        if (state) {
            System.out.println("Pulled Switch, Now turning off light");
            state = Boolean.FALSE;
        } else {
            System.out.println("Pulled Switch, Now turning on light");
            state = Boolean.TRUE;
        }
    }
}

class PressSwitchFan extends PressSwitch {

    boolean state;

    @Override
    public void toggle() {
        if (state) {
            System.out.println("Pressed Switch, Now turning off fan");
            state = Boolean.FALSE;
        } else {
            System.out.println("Pressed Switch, Now turning on fan");
            state = Boolean.TRUE;
        }
    }
}

class PressSwitchLight extends PressSwitch {

    boolean state;

    @Override
    public void toggle() {
        if (state) {
            System.out.println("Pressed Switch, Now turning off light");
            state = Boolean.FALSE;
        } else {
            System.out.println("Pressed Switch, Now turning on light");
            state = Boolean.TRUE;
        }
    }
}
