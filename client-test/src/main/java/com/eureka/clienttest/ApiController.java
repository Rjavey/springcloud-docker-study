package com.eureka.clienttest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/find")
    public String find(){

        return this.restTemplate.getForObject("http://www.baidu.com",String.class);
    }

    /**
     * restTemplate 不可与loadbalancerclient.choose写在同一个方法里 restTemplate已经包含choose
     */
    @GetMapping("/find2")
    public void instance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("service-helloworld");
        ApiController.logger.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }


    @HystrixCommand(fallbackMethod = "findByIdError")
    @GetMapping("/{id}")
    public String find(@PathVariable("id")Long id){
        return id.toString() + "111";
    }

    public String findByIdError(Long id){
        return id.toString();
    }

}
