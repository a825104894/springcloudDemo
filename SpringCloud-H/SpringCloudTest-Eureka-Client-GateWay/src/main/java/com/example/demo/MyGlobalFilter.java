package com.example.demo;

import java.time.ZonedDateTime;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Component
public class MyGlobalFilter implements GlobalFilter,Ordered {
	//过滤器执行优先级
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		 String first = exchange.getRequest().getQueryParams().getFirst("name");
		 if(StringUtils.isEmpty(first)) {
			 exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			 return exchange.getResponse().setComplete();
		 }
		return chain.filter(exchange);
	}
	
}
