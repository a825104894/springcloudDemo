package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
@RestController
public class SpringCloudTestEurekaClientConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTestEurekaClientConfigServerApplication.class, args);
	}


}
