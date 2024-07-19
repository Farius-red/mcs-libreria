package com.juliaosystem;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.common.lib"})
@EnableJpaRepositories(basePackages = {"com.common.lib.infraestructure.repository" ,"com.juliaosystem.infrastructure.repository"})
@EntityScan(basePackages = {"com.common.lib.infraestructure.entitis" , "com.juliaosystem.infrastructure.entitis"})
public class LibreriaApplication {


	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}


	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("springshop-public")
				.packagesToScan("com.juliaosystem")
				.build();
	}


}
