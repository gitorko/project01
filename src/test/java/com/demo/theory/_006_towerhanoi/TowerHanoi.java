package com.demo.theory._006_towerhanoi;

import org.junit.jupiter.api.Test;

public class TowerHanoi {

    @Test
    public void test() {
        move(3, 'A', 'B', 'C');
    }

    public void move(int numberOfDisc, char from, char to, char inter) {
        if (numberOfDisc == 1) {
            System.out.println("Moving disc 1 from " + from + " to " + to);
        } else {
            move(numberOfDisc - 1, from, inter, to);
            System.out.println("Moving disc " + numberOfDisc + " from " + from + " to " + to);
            move(numberOfDisc - 1, inter, to, from);
        }
    }
}
