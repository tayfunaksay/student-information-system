package com.studentinformationsystem.courseschedulingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CourseSchedulingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseSchedulingServiceApplication.class, args);
	}

}
