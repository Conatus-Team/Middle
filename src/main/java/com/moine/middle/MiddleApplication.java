package com.moine.middle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MiddleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddleApplication.class, args);
	}

}
