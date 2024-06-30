package com.assignment.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:user.properties")
public class AppConfig {
	
	@Autowired
    private Environment env;

    @Bean
    public Properties userProperties() {
        Properties properties = new Properties();
        properties.put("admin", env.getProperty("admin"));
        properties.put("staff", env.getProperty("staff"));
        return properties;
    }
}
