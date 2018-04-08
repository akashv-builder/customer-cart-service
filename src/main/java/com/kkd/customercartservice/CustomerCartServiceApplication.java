package com.kkd.customercartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class CustomerCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCartServiceApplication.class, args);
	}
}
