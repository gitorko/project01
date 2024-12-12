package com.demo.basics.designpatterns._03_abstractfactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

interface Animal {
    String sound();
}

interface AnimalFactory {
    Animal createAnimal();
}

public class AnimalAbstractFactoryPatternTest {

    @Test
    public void test() {
        Animal animal = AnimalAbstractFactory.getAnimal(new DogFactory());
        Assertions.assertEquals("Bark!", animal.sound());
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

class AnimalAbstractFactory {
    public static Animal getAnimal(AnimalFactory bf) {
        return bf.createAnimal();
    }
}

class DuckFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Duck();
    }
}

class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
