package com.silvio.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.silvio.cursomc.service.DBService;
import com.silvio.cursomc.service.EmailService;
import com.silvio.cursomc.service.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	/*@Value("${spring.jpa.hibernate.ddl.auto}")
	private String strategy;*/
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		/*if(!"create".equals(strategy)) {
			return false;
		}*/
		dbService.instantiateTestDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
