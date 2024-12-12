package com.demo.basics.designpatterns._09_flyweight;

import java.util.HashMap;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//divide Object property into intrinsic and extrinsic properties
enum BeeType {
    WORKER, ATTACKER;

    public static BeeType getRandom() {
        return BeeType.values()[new Random().nextInt(2)];
    }
}

interface Bee {
    void carryOutMission(int x, int y);
}

public class FlyWeightPatternTest {

    @Test
    public void test() {
        for (int i = 0; i < 1000; i++) {
            int posx = new Random().nextInt(10);
            int posy = new Random().nextInt(10);
            FlyweightBeeFactory.getBeeType(BeeType.getRandom()).carryOutMission(posx, posy);
        }
        System.out.println("Total Bee objects created:" + FlyweightBeeFactory.bees.size());
        Assertions.assertEquals(2, FlyweightBeeFactory.bees.size());
    }
}

class WorkerBee implements Bee {

    BeeType beeType;

    public WorkerBee(BeeType beeType) {
        //Takes long time
        System.out.println("Creating worker bee!");
        this.beeType = beeType;
    }

    @Override
    public void carryOutMission(int x, int y) {
        System.out.println("Depositing honey at (" + x + "," + y + ") quadrant!");
    }

}

class AttackBee implements Bee {

    BeeType beeType;

    public AttackBee(BeeType beeType) {
        //Takes long time
        System.out.println("Creating attack bee!");
        this.beeType = beeType;
    }

    @Override
    public void carryOutMission(int x, int y) {
        System.out.println("Defending (" + x + "," + y + ") quadrant!");
    }

}

class FlyweightBeeFactory {

    public static final HashMap<BeeType, Bee> bees = new HashMap<>();

    public static Bee getBeeType(BeeType beeType) {
        Bee bee = bees.get(beeType);
        if (bee == null) {
            if (beeType.equals(BeeType.WORKER)) {
                bee = new WorkerBee(beeType);
            } else {
                bee = new AttackBee(beeType);
            }
            bees.put(beeType, bee);
        }
        return bee;
    }

}
