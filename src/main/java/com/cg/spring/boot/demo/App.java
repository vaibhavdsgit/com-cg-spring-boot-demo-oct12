package com.cg.spring.boot.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		
//		private static final Logger LOG  = LoggerFactory.getLogger(App.class);
		final Logger LOG = LoggerFactory.getLogger(App.class);
		
		LOG.info("Start..........");
		SpringApplication.run(App.class, args);
		
		LOG.info("End");
//		System.out.println("End");
	}

}
