package com.demo.basics.designpatterns._08_proxy;

import org.junit.jupiter.api.Test;

interface Command {
    void runCommand(String cmd);
}

public class ProxyPatternTest {

    @Test
    public void test() {
        Proxy proxy = new Proxy();
        proxy.runCommand("rm");
        proxy.runCommand("dir");
    }
}

class CommandImpl implements Command {

    @Override
    public void runCommand(String cmd) {
        System.out.println("Running : " + cmd);
    }
}

class Proxy implements Command {

    Command cmdObj;

    public Proxy() {
        this.cmdObj = new CommandImpl();
    }

    @Override
    public void runCommand(String cmd) {
        if (cmd.contains("rm")) {
            System.out.println("Cant run rm");
        } else {
            cmdObj.runCommand(cmd);
        }
    }

}
