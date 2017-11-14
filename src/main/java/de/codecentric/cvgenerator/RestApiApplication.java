package de.codecentric.cvgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("de.codecentric.cvgenerator")
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories("de.codecentric.cvgenerator")
public class RestApiApplication {

	 public static void main(String[] args) {
	        SpringApplication.run(RestApiApplication.class, args);
	    }
	
}
