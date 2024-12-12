package com.demo.basics.designpatterns._01_singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -1L;

    private SerializedSingleton() {
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }

    @Test
    public void test() throws Exception {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        serialize(instanceOne);
        SerializedSingleton instanceTwo = deserialize();
        Assertions.assertEquals(instanceOne.hashCode(), instanceTwo.hashCode());
    }

    @SneakyThrows
    public void serialize(SerializedSingleton instanceOne) {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();
    }

    @SneakyThrows
    public SerializedSingleton deserialize() {
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();
        return instanceTwo;
    }

    public String hello() {
        return ("Hello from singleton!");
    }

    protected Object readResolve() {
        return getInstance();
    }

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

}
