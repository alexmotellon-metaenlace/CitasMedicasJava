package com.metaenlace.citasmedicas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.metaenlace.citasmedicas")
@EnableJpaRepositories(basePackages = "com.metaenlace.citasmedicas")
@EntityScan(basePackages = "com.metaenlace.citasmedicas")
public class CitasMedicasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitasMedicasApplication.class, args);
	}

}
