package com.demo.basics.designpatterns._27_autocloseable;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AutoCloseableTest {

    @Test
    void test() {
        Resource resource = new Resource();
        try(resource) {
            resource.operation();
        }
        Assertions.assertTrue(resource.isClosed(), "Resource should be closed");
    }
}

@Getter
class Resource implements AutoCloseable {
    private boolean closed = false;

    public Resource() {
        System.out.println("Open connection");
    }

    public void operation() {
        System.out.println("Operation");
    }

    public void close() {
        System.out.println("Close connection");
        closed = true;
    }
}