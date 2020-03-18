package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@SpringBootApplication
@EnableEurekaClient
@Configuration
@RestController
@EnableFeignClients
@RibbonClient(name = "PROVIDER",configuration = MyRule.class)
public class SpringCloudTestEurekaClientApplication {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	TestFeignClients tfc;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTestEurekaClientApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@GetMapping("/hello")
	public String helloWorld() {
		String result = restTemplate.getForObject("http://PROVIDER/helloWorld?name='123'", String.class);
		return result;
	}
	@GetMapping("/hello1")
	public String helloWorldFeignClient() {
		String name="123";
		return tfc.hi(name);
	}
	
	 
}
