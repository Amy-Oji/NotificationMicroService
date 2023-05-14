package com.amyojiakor.NotificationMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.amyojiakor.NotificationMicroService")
public class NotificationMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationMicroServiceApplication.class, args);
	}

}
