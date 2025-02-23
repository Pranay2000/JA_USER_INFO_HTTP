package com.assignment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigSecurity {
	
	@Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .requestMatchers("/appName/userDetail").authenticated()
                .and()
            .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
    	UserDetails user = User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles("USER")
                .build();
    	return new InMemoryUserDetailsManager(user);
    }
}