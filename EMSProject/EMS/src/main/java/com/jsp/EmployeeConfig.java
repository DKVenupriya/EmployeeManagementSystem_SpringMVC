package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.jsp")
public class EmployeeConfig {
	
	
	@Bean
	public EntityManager getEntityManager()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		return factory.createEntityManager();
	}

	@Bean //annotation can be used on spring boot also
	public EntityTransaction getEntityTransaction()
	{
		return getEntityManager().getTransaction();
		
	}
}
