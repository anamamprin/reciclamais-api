package br.com.fiap.reciclamais.reciclamaisapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.fiap")
public class ReciclamaisApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReciclamaisApiApplication.class, args);
	}

}
