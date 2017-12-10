package com.demo.authserver.config;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
	    http	
	    		.csrf().disable()
	    		.formLogin().permitAll()
	    		.and()
	    		.anonymous().disable()
	    		.httpBasic()
	    		.and()
	    		.authorizeRequests().anyRequest().authenticated()
	    		;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("pass").roles("USER")
			.and()
			.withUser("admin").password("adminpass").authorities("ROLE_ADMIN");
	}
	

	
}
