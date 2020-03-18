package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@RefreshScope
public class SpringCloudTestEurekaClientConfigClientApplication {
	
	@Value("${test}")
	private String test;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTestEurekaClientConfigClientApplication.class, args);
	}
	
	@RequestMapping("/h")
	public String get() {
		return test;
	}
}
