package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringCloudTestEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTestEurekaClientApplication.class, args);
	}
	
	@GetMapping("/helloWorld")
	public String helloWorld(@RequestParam String name) {
		return name+"8083";
	}
}
