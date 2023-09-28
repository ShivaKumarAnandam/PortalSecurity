package com.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("sai")
			.password("{noop}welcome")
			.authorities("ADMIN");
		auth.inMemoryAuthentication()
			.withUser("hero")
			.password("{noop}WELCOME")
			.authorities("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/admin").hasAuthority("ADMIN")
			.antMatchers("/user").hasAnyAuthority("USER", "ADMIN")
			.and()
			.formLogin()
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
}
