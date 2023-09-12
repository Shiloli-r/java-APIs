package com.validatepolicy.ValidatePolicy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ValidatePolicyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidatePolicyApplication.class, args);
	}

}
