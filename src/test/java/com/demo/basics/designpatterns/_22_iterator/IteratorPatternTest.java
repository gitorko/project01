package com.demo.basics.designpatterns._22_iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

interface FruitCollection {
    Iterator getIterator(String type);
}

public class IteratorPatternTest {

    @Test
    public void test() {

        FruitCollectionImpl collection = new FruitCollectionImpl();

        for (Iterator iter = collection.getIterator("COLOR"); iter.hasNext(); ) {
            Fruit fruit = (Fruit) iter.next();
            System.out.println(fruit);
        }
        System.out.println();
        for (Iterator iter = collection.getIterator("TYPE"); iter.hasNext(); ) {
            Fruit fruit = (Fruit) iter.next();
            System.out.println(fruit);
        }
    }
}

@AllArgsConstructor
@Data
class Fruit {
    String type;
    String color;
}

class FruitCollectionImpl implements FruitCollection {

    List<Fruit> fruits;

    FruitCollectionImpl() {
        fruits = new ArrayList<>();
        fruits.add(new Fruit("Banana", "Green"));
        fruits.add(new Fruit("Apple", "Green"));
        fruits.add(new Fruit("Banana", "Yellow"));
        fruits.add(new Fruit("Cherry", "Red"));
        fruits.add(new Fruit("Apple", "Red"));
    }

    @Override
    public Iterator getIterator(String type) {
        if (type.equals("COLOR")) {
            return new FruitIterator("COLOR");
        } else {
            return new FruitIterator("TYPE");
        }
    }

    private class FruitIterator implements Iterator {
        int index;
        List<Fruit> sortedFruits = new ArrayList<>(fruits);

        FruitIterator(String iteratorType) {
            if (iteratorType.equals("COLOR")) {
                Collections.sort(sortedFruits, Comparator.comparing(Fruit::getColor));
            } else {
                Collections.sort(sortedFruits, Comparator.comparing(Fruit::getType));
            }
        }

        @Override
        public boolean hasNext() {
            if (index < sortedFruits.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return sortedFruits.get(index++);
            }
            return null;
        }
    }

}