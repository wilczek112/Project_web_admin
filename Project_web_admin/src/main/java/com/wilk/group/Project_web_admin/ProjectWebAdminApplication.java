package com.wilk.group.Project_web_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ProjectWebAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWebAdminApplication.class, args);
	}

}
