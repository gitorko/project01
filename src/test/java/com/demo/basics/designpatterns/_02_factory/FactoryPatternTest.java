package com.demo.basics.designpatterns._02_factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

enum AnimalType {
    DOG, DUCK, CAT;
}

interface Animal {
    String sound();
}

public class FactoryPatternTest {

    @Test
    public void test() {
        Animal animal = Factory.getAnimal(AnimalType.CAT);
        Assertions.assertEquals("Meow!", animal.sound());
    }
}

class Duck implements Animal {

    @Override
    public String sound() {
        return "Quak!";
    }
}

class Dog implements Animal {

    @Override
    public String sound() {
        return "Bark!";
    }
}

class Cat implements Animal {

    @Override
    public String sound() {
        return "Meow!";
    }
}

class Factory {
    public static Animal getAnimal(AnimalType type) {
        switch (type) {
            case DOG:
                return new Dog();
            case CAT:
                return new Cat();
            case DUCK:
                return new Duck();
            default:
                return null;
        }
    }
}
