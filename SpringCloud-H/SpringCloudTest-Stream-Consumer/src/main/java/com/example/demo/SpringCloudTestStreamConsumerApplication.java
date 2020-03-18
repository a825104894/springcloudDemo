package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Sink.class)
@SpringBootApplication
public class SpringCloudTestStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTestStreamConsumerApplication.class, args);
	}
	@StreamListener(Sink.INPUT)
	public void receive(Message<String> msg) {
		System.out.println(msg.getPayload());
	}
}
