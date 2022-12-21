package com.example.clevertectaskrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaAuditing
@EnableCaching
@EnableTransactionManagement
@SpringBootApplication
public class ClevertecTaskRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClevertecTaskRestApplication.class, args);
	}

}
