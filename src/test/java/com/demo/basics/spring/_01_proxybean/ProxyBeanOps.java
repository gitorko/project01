package com.demo.basics.spring._01_proxybean;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootTest(classes = {MyApp1.class, MyApp2.class}) // Specify configuration class
public class ProxyBeanOps {

    @Autowired
    private MyApp1 myApp1;

    @Autowired
    private MyApp2 myApp2;


    @Test
    public void testProxyBeanMethods() {
        MyApp1.MyBean1 firstCall = myApp1.getMyBean1();
        MyApp1.MyBean1 secondCall = myApp1.getMyBean1();
        // Assert that the same instance is returned
        assertSame(firstCall, secondCall, "Expected the same instance when proxyBeanMethods=true");
    }

    @Test
    public void testBeanCreation() {
        MyApp2.MyBean2 firstCall = myApp2.getMyBean2();
        MyApp2.MyBean2 secondCall = myApp2.getMyBean2();
        assertNotSame(firstCall, secondCall, "Expected different instance when proxyBeanMethods=false");
    }

}

@Configuration(proxyBeanMethods = true)
class MyApp1 {
    @Bean
    public MyBean1 getMyBean1() {
        return new MyBean1("jack");
    }

    class MyBean1 {
        String name;

        public MyBean1(String name) {
            this.name = name;
        }
    }
}


@Configuration(proxyBeanMethods = false)
class MyApp2 {
    @Bean
    public MyBean2 getMyBean2() {
        return new MyBean2("jack");
    }

    class MyBean2 {
        String name;

        public MyBean2(String name) {
            this.name = name;
        }
    }
}

