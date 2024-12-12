package com.demo.basics.designpatterns._08_proxy_invocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

interface Command {
    void runCommand(String cmd);
}

public class ProxyHandlerPatternTest {

    @Test
    public void test() {
        Command cmd = (Command) CommandProxy.newInstance(new CommandImpl());
        cmd.runCommand("ls");
        Assertions.assertThrows(RuntimeException.class, () -> cmd.runCommand("rm"));
    }

}

class CommandImpl implements Command {

    @Override
    public void runCommand(String cmd) {
        System.out.println("Running : " + cmd);
    }
}

class CommandProxy implements InvocationHandler {
    private Object obj;

    private CommandProxy(Object obj) {
        this.obj = obj;
    }

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
                new CommandProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        try {
            if (args[0].equals("rm")) {
                throw new IllegalAccessException("rm command not allowed");
            } else {
                result = method.invoke(obj, args);
            }
            return result;
        } catch (InvocationTargetException ex) {
            throw ex.getTargetException();
        } catch (Exception ex) {
            throw new RuntimeException("invocation exception " + ex.getMessage());
        }
    }

}
