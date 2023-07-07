package com.innovacase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.innovacase.models")
@EnableJpaRepositories("com.innovacase.repositories")
public class MasraftakipApplicaton {

	public static void main(String[] args) {
		SpringApplication.run(MasraftakipApplicaton.class, args);
	}

}
