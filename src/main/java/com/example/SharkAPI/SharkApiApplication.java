package com.example.SharkAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SharkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharkApiApplication.class, args);
	}

	// http://localhost:8080/sharks for all sharks
	// http://localhost:8080/sharks/{id} for a certain shark through id 1-5
	// http://localhost:8080/sharks/search/{name} for a certain shark through name
	// http://localhost:8080/sharks/species/{species} for a certain shark through species
	// in post mode: http://localhost:8080/sharks/new to add more sharks
	// in put mode: http://localhost:8080/sharks/{id} to update a specific shark
	// in delete mode: http://localhost:8080/shark/{id} to delete a specific shark

}
