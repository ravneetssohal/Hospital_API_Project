package com.pragra.api_gateway_ravneet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayRavneetApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayRavneetApplication.class, args);
    }

}
