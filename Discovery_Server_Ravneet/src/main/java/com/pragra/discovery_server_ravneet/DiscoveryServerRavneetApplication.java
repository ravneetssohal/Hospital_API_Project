package com.pragra.discovery_server_ravneet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerRavneetApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerRavneetApplication.class, args);
    }

}
