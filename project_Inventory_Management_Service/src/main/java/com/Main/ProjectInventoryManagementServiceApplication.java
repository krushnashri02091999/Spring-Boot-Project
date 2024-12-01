package com.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "inv_repository")
public class ProjectInventoryManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectInventoryManagementServiceApplication.class, args);
		System.out.println("hellow from Inventory...");
		}

}
