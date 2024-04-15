package com.example.manageroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ManageRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageRoomApplication.class, args);
	}

}
