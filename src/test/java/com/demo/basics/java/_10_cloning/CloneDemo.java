package com.demo.basics.java._10_cloning;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * https://www.baeldung.com/java-deep-copy
 * https://www.vojtechruzicka.com/java-cloning-problems/
 */
public class CloneDemo {

    @Test
    public void test() {
        AddressB address1 = new AddressB("Downing St 10");
        UserB user1 = new UserB("John", address1);
        UserB user2 = (UserB) user1.clone();

        user1.getAddress().street = "New Street";
        System.out.println(user1);
        System.out.println(user2);

    }

    @Data
    @AllArgsConstructor
    class AddressB implements Cloneable {
        String street;

        @Override
        public Object clone() {
            try {
                return (AddressB) super.clone();
            } catch (CloneNotSupportedException e) {
                // fall back to copy constructor
                return new AddressB(this.street);
            }
        }
    }

    @Data
    @AllArgsConstructor
    class UserB implements Cloneable {
        String name;
        AddressB address;

        @Override
        public Object clone() {
            UserB user = null;
            try {
                user = (UserB) super.clone();
            } catch (CloneNotSupportedException e) {
                //fallback to copy constructor
                user = new UserB(this.getName(), new AddressB(this.getAddress().street));
            }
            //super.clone() call returns a shallow copy of an object, but we set deep copies of mutable fields
            user.address = (AddressB) this.address.clone();
            return user;
        }

    }
}
