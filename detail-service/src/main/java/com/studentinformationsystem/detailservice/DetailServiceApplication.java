package com.studentinformationsystem.detailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetailServiceApplication.class, args);
	}

}
