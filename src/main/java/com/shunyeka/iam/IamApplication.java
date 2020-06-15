package com.shunyeka.iam;

import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"com.shunyeka.iam"})
public class IamApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamApplication.class, args);

	}


	@Bean
	public AmazonIdentityManagement amazonIdentityManagement(){
		return AmazonIdentityManagementClientBuilder.standard().build();
	}






}
