package com.farkas.jobsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class JobsearchApplication {
	public static void main(String[] args) {
		SpringApplication.run(JobsearchApplication.class, args);
	}
}
