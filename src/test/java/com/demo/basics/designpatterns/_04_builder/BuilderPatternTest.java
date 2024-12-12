package com.demo.basics.designpatterns._04_builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuilderPatternTest {

    @Test
    public void test() {
        Dog dog1 = new Dog.DogBuilder().setName("Rocky").setBreed("German Shepherd").setColor("Grey").setAge(6).setWeight(40.5).build();
        Assertions.assertEquals(40.5, dog1.getWeight());
        Dog dog2 = new Dog.DogBuilder().setName("Rocky").setBreed("German Shepherd").build();
        Assertions.assertEquals(30.0, dog2.getWeight());

        Cat cat = Cat.builder().name("Fluffy").breed("Egyptian").build();
        Assertions.assertEquals(10.0, cat.getWeight());
    }

}

@Getter
@ToString
class Dog {

    private String name;
    private String breed;
    private String color;
    private int age;
    private double weight;

    private Dog(DogBuilder builder) {
        this.name = builder.name;
        this.breed = builder.breed;
        this.color = builder.color;
        this.age = builder.age;
        this.weight = builder.weight;
    }

    @Getter
    public static class DogBuilder {

        private String name;
        private String breed;
        private String color;
        private int age;
        private double weight;

        public DogBuilder() {
            this.weight = 30.0;
        }

        public Dog build() {
            return new Dog(this);
        }

        public DogBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public DogBuilder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public DogBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public DogBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public DogBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }
    }
}

@Builder
@Getter
@ToString
class Cat {

    private String name;
    private String breed;
    private String color;
    private int age;
    @Builder.Default
    private double weight = 10.0;
}