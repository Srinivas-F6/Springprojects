package com.microservices.ecom_order_service.config;

import java.time.Duration;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservices.ecom_order_service.Exception.CustomErrorDecoder;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfig {

	@Bean
	public Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
	
	@Bean 
	public Request.Options options(){
		return new Request.Options(Duration.ofMillis(3000),Duration.ofMillis(5000),true);
	}
	
	@Bean
	public Retryer retryer() {
		return new Retryer.Default(1,2,4);
	}
	
	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate ->{
			requestTemplate.header("x-correlation-id",UUID.randomUUID().toString());
		};
	}
	
	@Bean
	public ErrorDecoder errorDecoder() {
		return new CustomErrorDecoder();
	}
}
