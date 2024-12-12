package com.demo.basics.designpatterns._01_singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BreakSingletonByReflection {

    private static boolean testSingleton() {
        ThreadSafeSingletonDoubleCheckLock instanceOne = ThreadSafeSingletonDoubleCheckLock.getInstance();
        ThreadSafeSingletonDoubleCheckLock instanceTwo = null;
        try {
            Constructor[] constructors = ThreadSafeSingletonDoubleCheckLock.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (ThreadSafeSingletonDoubleCheckLock) constructor.newInstance();
                break;
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                 | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        if (instanceOne.hashCode() != instanceTwo.hashCode()) {
            System.out.println("Singleton broken as hashcode differs!");
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        Assertions.assertFalse(testSingleton());
    }

}
