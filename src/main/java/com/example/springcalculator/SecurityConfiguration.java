package com.example.springcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.springcalculator.security.JPARepositoryUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
	
	@Autowired
	private JPARepositoryUserDetailsServiceImpl detailsService;
	
	@Bean
	UserDetailsService userDetails() {
		return detailsService;
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.formLogin((form) -> {
			form.loginPage("/login")
				.defaultSuccessUrl("/calculate")
				.loginProcessingUrl("/logincheck")
				.failureUrl("/login?error=1");
				
		}).logout((logout) -> {
			logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
		}).userDetailsService(userDetails());
		
		return http.build();
	}
}
