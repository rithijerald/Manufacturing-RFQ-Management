package com.cts.Rfq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cts")
public class RfqApplication {

	public static void main(String[] args) {
		SpringApplication.run(RfqApplication.class, args);
	}

}
