package com.kielce.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.kielce")
public class AppStarter extends SpringBootServletInitializer  {

	protected static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);
	
	public static void main(String[] args) {
		LOGGER.info("Initializing com.kielce app !");
		SpringApplication.run(AppStarter.class, args);
}
	
}
