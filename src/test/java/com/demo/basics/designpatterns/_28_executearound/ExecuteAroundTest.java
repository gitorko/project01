package com.demo.basics.designpatterns._28_executearound;

import java.util.function.Consumer;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExecuteAroundTest {

    @Test
    public void test() {
        Resource resource = Resource.use(r -> {
            r.op1()
             .op2();
        });
        Assertions.assertTrue(resource.isClosed(), "Resource should be closed after use");

    }
}

@Getter
class Resource {
    private boolean closed = false;

    private Resource() {
        System.out.println("Open connection");
    }

    public static Resource use(Consumer<Resource> block) {
        Resource resource = new Resource();
        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
        return resource; // Return the resource for verification
    }

    public Resource op1() {
        System.out.println("Op1");
        return this;

    }

    public Resource op2() {
        System.out.println("Op2");
        return this;
    }

    private void close() {
        System.out.println("Close connection");
        closed = true;
    }
}
