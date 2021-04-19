package com.ontarioinc.mediaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MediaAppApplication {

	public static void main(String[] args) {
		System.out.println(System.getProperty("server.servlet.context-path"));
		SpringApplication.run(MediaAppApplication.class, args);
		System.out.println(System.getProperty("server.servlet.context-path"));
	}

}
