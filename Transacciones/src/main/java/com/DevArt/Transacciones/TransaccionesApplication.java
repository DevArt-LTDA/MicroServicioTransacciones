package com.DevArt.Transacciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.DevArt.Transacciones.client")
public class TransaccionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransaccionesApplication.class, args);
	}
}
