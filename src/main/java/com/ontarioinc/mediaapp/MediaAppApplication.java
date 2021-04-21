package com.ontarioinc.mediaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ontarioinc.mediaapp.db.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MediaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaAppApplication.class, args);
	}

}
