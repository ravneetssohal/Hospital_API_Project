package com.pragra.springapiravneet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringApiRavneetApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiRavneetApplication.class, args);
    }

}
