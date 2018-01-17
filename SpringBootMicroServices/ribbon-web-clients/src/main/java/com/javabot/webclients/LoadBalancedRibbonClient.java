package com.javabot.webclients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author  Yeshwanth
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan("com.javabot")
public class LoadBalancedRibbonClient {
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
		
	public static void main(String[] args) {
		SpringApplication.run(LoadBalancedRibbonClient.class, args);
	}
	
	/** 
	 * Spring by default has a feature of identifying Path Extensions,
	 * Ex: if you send email(abc@gmail.com) on path to consume service.Spring ignores things after last dot(.) by treating that as extension.
	 * it takes only (abc@gmai).to avoid these problem,you have to disable favorPathExtension and in resource RequestMapping use regex like this {email:.+}
	 */
	@Configuration
    public static class PathMatchingConfigurationAdapter extends WebMvcConfigurerAdapter {
 
        @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
            configurer.favorPathExtension(false);
        }
    }
	
}
