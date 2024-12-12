package com.demo.basics.spring._02_configurations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@SpringBootTest(classes = {MyAppConfig.class})
public class ConfigBeanOps {

    @Autowired
    MyAppConfig myAppConfig;

    @Test
    public void testProxyBeanMethods() {
        /**
         * To override the properties in application.properties define
         * test2.serverName=test2
         * test2.serverPort=9090
         */
        assertEquals("test", myAppConfig.myAppProps.getServerName());
        assertEquals("8090", myAppConfig.myAppProps.getServerPort());
    }
}

/**
 * Auto-Configuration: If your project has a @SpringBootApplication,
 * Spring Boot will automatically scan for @ConfigurationProperties classes without explicitly needing @EnableConfigurationProperties.
 * However, you may still use @EnableConfigurationProperties to explicitly declare and manage them.
 */
@Configuration
@EnableConfigurationProperties(MyAppProps.class)
class MyAppConfig {

    @Autowired
    MyAppProps myAppProps;
}