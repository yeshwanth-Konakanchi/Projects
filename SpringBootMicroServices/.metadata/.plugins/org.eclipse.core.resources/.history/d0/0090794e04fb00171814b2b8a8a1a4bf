package com.javabot.webclients.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author  Jagan Reddy
 * 
 * Swagger configuration for API Documentation
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${info.app.name}")
	private String appName;

	@Value("${info.app.description}")
	private String appDescription;

	@Value("${info.app.version}")
	private String appVersion;
    
	@Bean
    public Docket WebServiceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.javabot.webclients.controller"))
                .paths(PathSelectors.regex(".*"))        
                .build()
                .apiInfo(metaData());
    }
	
    private ApiInfo metaData() {
    	return new ApiInfoBuilder()
                .title(appName)
                .description(appDescription)
                .version(appVersion)
                .contact(new Contact("Javabot", "http://www.ekthasol.com/", "javabot.netflix@gmail.com"))
                .build();
    }
}
