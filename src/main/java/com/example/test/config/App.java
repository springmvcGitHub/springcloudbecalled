package com.example.test.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Title:
 * Description:
 * Copyright:
 * Company:
 * Project: SrpingBootTest
 * Create User: TRS-chen
 * Create Time:2018/8/4 18:10
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.example.test"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.example.test.feignInterface"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    @LoadBalanced
//    RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
}
