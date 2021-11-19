package com.cg.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	private static final Logger LOG = LoggerFactory.getLogger(Hello.class);
	
	
	@RequestMapping("/hello")
	public String hello() {
		//System.out.println("Hello.........");
		LOG.info("Hello.....");
		return "Hello world........";
	}
	
	@RequestMapping("/bye")
	public String bye() {
		System.out.println("Bye");
		return "Bye World";
	}
	
	@RequestMapping("/double")
	public double value() {
		System.out.println("Double value");
		return 20.56;
	}
	
	
	
	
}
