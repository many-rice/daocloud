package com.daocloud.cloud1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Cloud1Application {

	public static void main(String[] args) {
		SpringApplication.run(Cloud1Application.class, args);
	}
}