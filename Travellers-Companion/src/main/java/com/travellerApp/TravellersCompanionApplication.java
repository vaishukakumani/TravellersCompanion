package com.travellerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages ={"com.travellerApp"})
@EntityScan(basePackages={"com.travellerApp.*"})
@EnableJpaRepositories(basePackages={"com.travellerApp.*"})
@EnableWebMvc
public class TravellersCompanionApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(TravellersCompanionApplication.class, args);
	}
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TravellersCompanionApplication.class);
    }
}
