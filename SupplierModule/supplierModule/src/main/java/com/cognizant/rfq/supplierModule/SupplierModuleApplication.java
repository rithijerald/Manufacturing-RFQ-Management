package com.cognizant.rfq.supplierModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class SupplierModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierModuleApplication.class, args);
	}

}
