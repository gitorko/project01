package com.demo.basics.designpatterns._21_interpreter;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

interface Expression {
    String interpret(InterpreterContext ctx);
}

public class InterpreterPatternTest {

    @Test
    public void test() {
        String input = "30 in binary";
        if (input.contains("binary")) {
            int val = Integer.parseInt(input.substring(0, input.indexOf(" ")));
            System.out.println(new IntToBinaryExpression(val).interpret(new InterpreterContext()));
        }

        input = "30 in hexadecimal";
        if (input.contains("hexadecimal")) {
            int val = Integer.parseInt(input.substring(0, input.indexOf(" ")));
            System.out.println(new IntToHexExpression(val).interpret(new InterpreterContext()));
        }
    }

}

class InterpreterContext {
    public String getBinaryFormat(int val) {
        return Integer.toBinaryString(val);
    }

    public String getHexFormat(int val) {
        return Integer.toHexString(val);
    }
}

@Data
@AllArgsConstructor
class IntToBinaryExpression implements Expression {

    int val;

    @Override
    public String interpret(InterpreterContext ctx) {
        return ctx.getBinaryFormat(val);
    }
}

@Data
@AllArgsConstructor
class IntToHexExpression implements Expression {

    int val;

    @Override
    public String interpret(InterpreterContext ctx) {
        return ctx.getHexFormat(val);
    }
}