package com.cognizant.authorization;





import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


import com.cognizant.authorization.model.MyUser;
import com.cognizant.authorization.repository.MyUserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class AuthorizationServiceApplication {
	@Autowired
	private MyUserRepository repository;
	
	 @PostConstruct
	    public void initUsers() {
	        List<MyUser> users = Stream.of(
	                new MyUser("rithi", "rithi", "rithi@gmail.com"),
	                new MyUser("himanshu", "himanshu", "himanshu@gmail.com"),
	                new MyUser("loki", "loki", "loki@gmail.com"),
	                new MyUser("jahanvi", "jahanvi", "jahanvi@.com")
	        ).collect(Collectors.toList());
	        repository.saveAll(users);
	    }

	public static void main(String[] args) {
		log.debug("START");
		SpringApplication.run(AuthorizationServiceApplication.class, args);
		log.debug("END");
	}
	

}
