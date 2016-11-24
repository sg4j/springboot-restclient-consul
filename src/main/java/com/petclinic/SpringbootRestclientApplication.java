package com.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class SpringbootRestclientApplication {

	public static void main(String[] args) {
		System.out.println("Port is "+args[0]);
		System.setProperty("server.port", args[0]);
		SpringApplication.run(SpringbootRestclientApplication.class, args);
	}
}
