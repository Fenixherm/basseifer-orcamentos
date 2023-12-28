package com.basseifer.orcamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication //(exclude = {SecurityAutoConfiguration.class})
public class OrcamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrcamentoApplication.class, args);
	}

}
