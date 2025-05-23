package com.example.parcial2;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Parcial2Application {

	public static void main(String[] args) {
		loadDotenv();
		SpringApplication.run(Parcial2Application.class, args);
	}

	public static void loadDotenv(){
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
	}

}
