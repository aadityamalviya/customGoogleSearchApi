package com.api.testgoogle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GoogleapitestApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GoogleapitestApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GoogleapitestApplication.class, args);
	}

}
