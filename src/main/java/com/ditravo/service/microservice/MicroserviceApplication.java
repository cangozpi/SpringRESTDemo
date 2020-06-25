package com.ditravo.service.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = {
    DataSourceAutoConfiguration.class
})
public class MicroserviceApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	repository.deleteAll();
	repository.save(new Person("george", "floyd"));

	}
}
