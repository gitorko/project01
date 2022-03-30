package com.demo.basics.puzzle._005_immutable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://www.baeldung.com/java-copy-hashmap
 */
public class ImmutablePuzzle {

    @Test
    public void test() {
        Map<String, String> props = new HashMap<>();
        props.put("city", "london");
        Person p1 = new Person("Jack", 34, new Date(), props);
        System.out.println(p1);
        p1.getDob().setTime(123);
        p1.getProps().put("city", "bangalore");
        System.out.println(p1);
    }

    final class Person {
        private final String name;
        private final Integer age;
        private final Date dob;
        private final Map<String, String> props;

        public Person(String name, Integer age, Date dob, Map<String, String> props) {
            this.name = name;
            this.age = age;
            this.dob = dob;
            this.props = props;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Date getDob() {
            return dob;
        }

        public Map<String, String> getProps() {
            return props;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", dob=" + dob +
                    ", props=" + props +
                    '}';
        }
    }
}
