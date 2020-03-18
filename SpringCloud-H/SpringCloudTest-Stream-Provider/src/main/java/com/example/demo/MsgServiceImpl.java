package com.example.demo;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@EnableBinding(Source.class)
public class MsgServiceImpl implements MsgSevice{
	@Resource
	private MessageChannel output;
	@Override
	public String send() {
		String uuid=UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(uuid).build());
		System.out.println("已发送"+uuid);
		return null;
	}

}
