package com.demo.basics.designpatterns._15_chainofresponsibility;

import org.junit.jupiter.api.Test;

interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    void dispense(int amount);
}

public class ChainResponsibilityPatternTest {

    @Test
    public void test() {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        int amount = 530;
        if (amount % 10 != 0) {
            System.out.println("Amount should be in multiple of10s.");
        } else {
            atmDispenser.c1.dispense(amount);
        }
    }
}

class ATMDispenseChain {

    public DispenseChain c1;

    public ATMDispenseChain() {

        DispenseChain c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        this.c1 = c1;
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

}


class Dollar10Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 10) {
            int num = amount / 10;
            int remainder = amount % 10;
            System.out.println("Dispensing " + num + " 10$ note");
            if (remainder != 0) {
                this.chain.dispense(remainder);
            }
        } else {
            this.chain.dispense(amount);
        }
    }
}

class Dollar20Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 20) {
            int num = amount / 20;
            int remainder = amount % 20;
            System.out.println("Dispensing " + num + " 20$ note");
            if (remainder != 0) {
                this.chain.dispense(remainder);
            }
        } else {
            this.chain.dispense(amount);
        }
    }
}

class Dollar50Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 50) {
            int num = amount / 50;
            int remainder = amount % 50;
            System.out.println("Dispensing " + num + " 50$ note");
            if (remainder != 0) {
                this.chain.dispense(remainder);
            }
        } else {
            this.chain.dispense(amount);
        }
    }
}
