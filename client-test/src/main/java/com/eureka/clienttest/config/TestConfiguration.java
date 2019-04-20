package com.eureka.clienttest.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "service-helloworld",configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
