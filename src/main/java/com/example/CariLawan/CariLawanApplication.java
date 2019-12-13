package com.example.CariLawan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CariLawanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CariLawanApplication.class, args);
	}

}
