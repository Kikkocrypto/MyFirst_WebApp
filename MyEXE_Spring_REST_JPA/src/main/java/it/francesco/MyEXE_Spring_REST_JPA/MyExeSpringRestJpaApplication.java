package it.francesco.MyEXE_Spring_REST_JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class MyExeSpringRestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyExeSpringRestJpaApplication.class, args);
	}

}
