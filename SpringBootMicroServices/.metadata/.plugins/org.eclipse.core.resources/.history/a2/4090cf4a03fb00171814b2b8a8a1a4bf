package com.javabot.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author  Jagan Reddy
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableJpaRepositories
@ComponentScan("com.javabot")
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}	
	
	/** 
	 * Spring by default has a feature of identifying Path Extensions,
	 * Ex: if you send email(abc@gmail.com) on path to consume service.Spring ignores things after last dot(.) by treating that as extension.
	 * it takes only (abc@gmai).to avoid these problem,you have to disable favorPathExtension and in resource RequestMapping use regex like this {email:.+}
	 * 
	 */
	@Configuration
    public static class PathMatchingConfigurationAdapter extends WebMvcConfigurerAdapter {
 
        @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
            configurer.favorPathExtension(false);
        }
    }
}
