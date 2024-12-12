package com.demo.basics.spring._02_configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "test2")
@Data
public class MyAppProps {
    private String serverName = "test";
    private String serverPort = "8090";
}
