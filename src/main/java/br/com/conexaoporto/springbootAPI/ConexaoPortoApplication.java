package br.com.conexaoporto.springbootAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.conexaoporto.springbootAPI.controllers")
public class ConexaoPortoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConexaoPortoApplication.class, args);
	}

}
