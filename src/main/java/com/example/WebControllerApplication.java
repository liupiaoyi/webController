package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class WebControllerApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		//SpringApplication.run(WebControllerApplication.class, args);
		SpringApplication app = new SpringApplication(WebControllerApplication.class);
		app.run(args);
	}
}
