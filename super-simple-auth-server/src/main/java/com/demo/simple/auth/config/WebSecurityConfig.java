package com.demo.simple.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private AuthenticationManager authenticationManager;
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.requestMatchers()
//          .antMatchers("/login", "/oauth/authorize")
//          .and()
//          .authorizeRequests()
//          .anyRequest().authenticated()
//          .and()
//          .formLogin().permitAll()
//          .and()
//          .anonymous().disable()
//          .httpBasic()
//         ;
        
        http	
//		.antMatcher("/**")
//			.authorizeRequests()
//				.antMatchers("/", "/login**", "/webjars/**").permitAll()
//				.anyRequest().authenticated()
//		.and()
//			.exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
//		.and()
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
        auth.parentAuthenticationManager(authenticationManager)
          .inMemoryAuthentication()
          .withUser("john").password("123").roles("USER");
    }
}
