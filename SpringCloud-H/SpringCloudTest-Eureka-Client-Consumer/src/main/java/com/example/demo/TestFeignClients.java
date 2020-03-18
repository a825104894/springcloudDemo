package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "PROVIDER")
public interface TestFeignClients {
	@RequestMapping(value="/helloWorld",method=RequestMethod.GET)
	public  String hi(@RequestParam String name);

}
