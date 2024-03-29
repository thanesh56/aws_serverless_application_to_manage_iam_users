package com.shunyeka.iam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shunyeka.iam"))
                .paths(regex("/iam.*"))
                .build()
                .apiInfo(metaInfo());
    }

    List<VendorExtension> vendorExtension = new ArrayList<>();

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "IAM User Management",
                "This is an application where we can perform the AIM Related Crud and Sync with DynamoDb Operation ",
                "1.0.4",
                "Terms of service",
                new Contact("IAMUsers","ec2-100-25-15-84.compute-1.amazonaws.com:9002/iam/users/","er.thaneshwarsahu@gmail.com"),
                "Apache Licence Version 2.0",
                "https://www.apache.org/license.html",
                vendorExtension
        );
        return apiInfo;
    }


}
