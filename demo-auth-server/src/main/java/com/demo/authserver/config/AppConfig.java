package com.demo.authserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.authserver.helper.ClientResources;

@Configuration
public class AppConfig {

	@Bean
	@ConfigurationProperties("facebook")
	public ClientResources facebook() {
	  return new ClientResources();
	}
}
