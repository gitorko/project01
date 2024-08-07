package com.demo.basics.java._10_cloning;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.SerializationUtils;

/**
 * https://www.baeldung.com/java-deep-copy
 * https://www.vojtechruzicka.com/java-cloning-problems/
 */
public class CloneSerialize {
    public static void main(String[] args) {
        AddressA address1 = new AddressA("Downing St 10");
        UserA user1 = new UserA("John", address1);
        UserA user2 = (UserA) SerializationUtils.clone(user1);

        user1.getAddress().street = "New Street";
        System.out.println(user1);
        System.out.println(user2);

    }
}

@Data
@AllArgsConstructor
class AddressA implements Serializable {
    private static final long serialVersionUID = 1L;
    String street;
}

@Data
@AllArgsConstructor
class UserA implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    AddressA address;

}
