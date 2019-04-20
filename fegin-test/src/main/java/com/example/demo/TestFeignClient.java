package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-helloworld")
@Component
public interface TestFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    String findById(@PathVariable("id")Long id);

}
