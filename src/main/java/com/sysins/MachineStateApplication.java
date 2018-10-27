package com.sysins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {"com.sysins"})
@EnableJpaRepositories

//@EnableWebMvc

public class MachineStateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MachineStateApplication.class, args);
	}
}
