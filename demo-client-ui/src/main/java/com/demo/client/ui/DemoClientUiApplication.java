package com.demo.client.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@EnableOAuth2Sso
public class DemoClientUiApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoClientUiApplication.class, args);
	}
}
