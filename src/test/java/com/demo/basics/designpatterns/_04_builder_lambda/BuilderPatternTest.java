package com.demo.basics.designpatterns._04_builder_lambda;

import java.util.function.Consumer;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuilderPatternTest {

    @Test
    public void test() {
        Dog dog1 = Dog.createDog(dog ->
                dog.setBreed("German Shepherd")
                        .setName("Rocky")
        );
        Assertions.assertEquals("Rocky", dog1.getName());
    }
}

@Getter
class Dog {

    private String name;
    private String breed;

    private Dog() {
    }

    public static Dog createDog(Consumer<Dog> block) {
        Dog dog = new Dog();
        //Can also use from pool of objects instead of creating new object
        block.accept(dog);
        return dog;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public Dog setBreed(String breed) {
        this.breed = breed;
        return this;
    }

}
