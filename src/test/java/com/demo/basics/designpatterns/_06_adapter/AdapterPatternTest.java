package com.demo.basics.designpatterns._06_adapter;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

interface Ship {
    String scan();

    String fire();
}

public class AdapterPatternTest {

    @Test
    public void test() {
        SpaceShipAdapter shipAdapter = new SpaceShipAdapter(new AlienCraft());
        Assertions.assertEquals("Scanning enemy", shipAdapter.scan());
        Assertions.assertEquals("Firing weapon", shipAdapter.fire());
    }
}

class AlienCraft {
    public String drakarys() {
        return "Firing weapon";
    }

    public String jorarghugon() {
        return "Scanning enemy";
    }
}

class EnterpriseCraft {
    public String zapIt() {
        return "Firing weapon";
    }

    public String acquireTarget() {
        return "Scanning enemy";
    }
}

@AllArgsConstructor
class SpaceShipAdapter implements Ship {
    AlienCraft ship;

    @Override
    public String scan() {
        return ship.jorarghugon();
    }

    @Override
    public String fire() {
        return ship.drakarys();
    }

}