package com.eureka.clienttest.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon config bean
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        // 负载均衡规则 改为随机
        return new RandomRule();
    }


}
