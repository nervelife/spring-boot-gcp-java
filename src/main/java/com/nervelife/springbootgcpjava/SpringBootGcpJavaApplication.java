package com.nervelife.springbootgcpjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class SpringBootGcpJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGcpJavaApplication.class, args);
	}

}
