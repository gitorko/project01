package com.demo.basics.designpatterns._09_flyweight_bad;

import java.util.Random;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

enum BeeType {
    WORKER, ATTACKER;

    public static BeeType getRandom() {
        //Returns random bee types.
        return BeeType.values()[new Random().nextInt(2)];
    }
}

interface Bee {
    void carryOutMission(int x, int y);
}

public class WrongFlyWeightPatternTest {

    @Test
    public void test() {
        int i = 0;
        for (; i < 100; i++) {
            int posx = new Random().nextInt(10);
            int posy = new Random().nextInt(10);
            BeeType type = BeeType.getRandom();
            if (type.equals(BeeType.WORKER)) {
                new WorkerBee(BeeType.getRandom()).carryOutMission(posx, posy);
            } else {
                new AttackBee(BeeType.getRandom()).carryOutMission(posx, posy);
            }

        }
        System.out.println("Total Bee objects created:" + i);
        Assertions.assertEquals(100, i);
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
        System.out.println(beeType + ", Depositing honey at (" + x + "," + y + ") quadrant!");
    }

}

class AttackBee implements Bee {

    BeeType beeType;

    @SneakyThrows
    public AttackBee(BeeType beeType) {
        //Takes long time
        System.out.println("Creating attack bee!");
        this.beeType = beeType;
    }

    @Override
    public void carryOutMission(int x, int y) {
        System.out.println(beeType + ", Defending (" + x + "," + y + ") quadrant!");
    }

}
