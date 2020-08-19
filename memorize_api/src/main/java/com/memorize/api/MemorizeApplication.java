package com.memorize.api;

import com.memorize.security.MemorizeSecurityApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MemorizeSecurityApplication.class)
public class MemorizeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemorizeApplication.class, args);
	}

}
