package com.demo.basics.java._10_cloning;

import lombok.AllArgsConstructor;
import lombok.Data;

//https://www.vojtechruzicka.com/java-cloning-problems/

// https://www.baeldung.com/java-deep-copy
public class CloneCopyConstruct {
    public static void main(String[] args) {
        Address address1 = new Address("Downing St 10");
        User user1 = new User("John", address1);
        User user2 = new User(user1);

        user1.getAddress().street = "New Street";
        System.out.println(user1);
        System.out.println(user2);

    }
}

@Data
@AllArgsConstructor
class Address {
    String street;

    //Copy constructor
    public Address(Address that) {
        this(that.getStreet());
    }
}

@Data
@AllArgsConstructor
class User {
    String name;
    Address address;

    //Copy constructor
    public User(User that) {
        this(that.getName(), new Address(that.getAddress()));
    }
}
