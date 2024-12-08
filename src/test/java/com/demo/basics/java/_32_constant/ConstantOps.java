package com.demo.basics.java._32_constant;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class ConstantOps {

    @Test
    void test() throws IllegalAccessException {
        System.out.println(MyConstant.CONST_VAR);

        var declaredFields = ConstantOps.MyConstant.class.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
            System.out.println(field.get(null));
        }
    }

    interface MyConstant {
        //No need to mention 'public static final'
        String CONST_VAR = "JACK";
    }
}
