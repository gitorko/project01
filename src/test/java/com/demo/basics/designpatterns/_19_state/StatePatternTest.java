package com.demo.basics.designpatterns._19_state;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

interface State {
    void doAction();
}

public class StatePatternTest {
    @Test
    public void test() {
        GameContext game = new GameContext();

        StartState startState = new StartState();
        StopState stopState = new StopState();

        game.setState(startState);
        game.doAction();

        game.setState(stopState);
        game.doAction();
    }
}

class StartState implements State {

    public void doAction() {
        System.out.println("Roll the dice!");
    }
}

class StopState implements State {

    public void doAction() {
        System.out.println("Game Over!");
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class GameContext implements State {
    private State state;

    @Override
    public void doAction() {
        this.state.doAction();
    }
}