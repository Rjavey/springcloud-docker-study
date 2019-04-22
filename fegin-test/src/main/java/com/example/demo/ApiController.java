package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);


    @Autowired
    private TestFeignClient testFeignClient;

    @HystrixCommand(fallbackMethod = "findByIdError")
    @RequestMapping("/user/{id}")
    public String findById(@PathVariable("id")Long id){
        System.out.println(1111111111);
        return this.testFeignClient.findById(id);
    }

    public String findByIdError(Long id,Throwable throwable){
        LOGGER.error("异常",throwable);
        return id.toString();
    }
}
