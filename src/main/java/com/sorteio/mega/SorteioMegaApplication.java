package com.sorteio.mega;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@EnableFeignClients
@SpringBootApplication
public class SorteioMegaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SorteioMegaApplication.class, args);
	}

}
