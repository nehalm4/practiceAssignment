package com.example.profile.utils;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Application {
	
	@Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
          .driverClassName("com.mysql.cj.jdbc.Driver")
          .url("jdbc:mysql://localhost:3306/profile")
          .username("profileUser")
          .password("profilePass")
          .build();	
    }
	
//	@Bean(name = "applicationProperties")
//    public PropertiesFactoryBean applicationProperties() {
//        PropertiesFactoryBean bean = new PropertiesFactoryBean();
//        bean.setLocation(new ClassPathResource("application.properties"));
//        return bean;
//    }

}
