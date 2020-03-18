package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudTestStreamConsumerApplication {
	@Autowired
	MsgSevice msgService;
	@RequestMapping("/send")
	public void sendMessage() {
			msgService.send();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTestStreamConsumerApplication.class, args);
	}

}
