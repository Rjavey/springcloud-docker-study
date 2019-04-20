package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private TestFeignClient testFeignClient;

    @RequestMapping("/user/{id}")
    public String findById(@PathVariable("id")Long id){
        return this.testFeignClient.findById(id);
    }
}
