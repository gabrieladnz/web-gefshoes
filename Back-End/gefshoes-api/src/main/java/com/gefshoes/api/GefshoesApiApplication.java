package com.gefshoes.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe para executar a API.
 *
 * @author João Guedes.
 */
@SpringBootApplication
@RestController
public class GefshoesApiApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(GefshoesApiApplication.class, args);
	}

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedHeaders("*")
            .allowedMethods("*")
            .exposedHeaders("*");
            WebMvcConfigurer.super.addCorsMappings(registry);
    }
	
}
