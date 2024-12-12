package com.demo.basics.designpatterns._14_mediator;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

interface ChatMediator {

    void sendMessage(String msg, User user);

    void addUser(User user);
}

public class MediatorPatternTest {

    @Test
    public void test() {

        ChatMediator mediator = new ChatMediatorImpl();
        User user1 = new User(mediator, "Raj");
        User user2 = new User(mediator, "Jacob");
        User user3 = new User(mediator, "Henry");
        User user4 = new User(mediator, "Stan");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);
        user1.send("Hi All");

    }
}

class ChatMediatorImpl implements ChatMediator {

    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User user) {
        for (User u : this.users) {
            if (u != user) {
                u.receive(msg);
            }
        }
    }
}

@AllArgsConstructor
class User {

    private ChatMediator mediator;
    private String name;

    public void send(String msg) {
        System.out.println(this.name + ": Sending Message=" + msg);
        mediator.sendMessage(msg, this);
    }

    public void receive(String msg) {
        System.out.println(this.name + ": Received Message:" + msg);
    }
}
