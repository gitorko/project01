package com.demo.basics.designpatterns._23_memento;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

public class MementoPatternTest {

    @Test
    public void test() {

        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker(originator);
        careTaker.save();

        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.save();

        originator.setState("State #3");
        careTaker.save();

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        careTaker.undo();
        System.out.println("Current State: " + originator.getState());

        careTaker.undo();
        System.out.println("Current State: " + originator.getState());

        careTaker.undo();
        careTaker.undo();
        careTaker.undo();
        System.out.println("Current State: " + originator.getState());
    }
}

@Data
@AllArgsConstructor
class Memento {
    private String state;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Originator {
    private String state;

    public Memento saveState() {
        return new Memento(this.state);
    }

    public void undoState(Memento memento) {
        this.state = memento.getState();
    }

}

@RequiredArgsConstructor
class CareTaker {
    final Originator origin;
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void save() {
        if (origin.getState() != null) {
            mementoList.add(origin.saveState());
        }
    }

    public void undo() {
        if (!mementoList.isEmpty()) {
            origin.undoState(mementoList.get(mementoList.size() - 1));
            mementoList.remove(mementoList.size() - 1);
        }
    }
}