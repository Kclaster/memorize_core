package com.memorize.api;

import com.memorize.security.MemorizeSecurityApplication;
import com.memorize.security.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MemorizeSecurityApplication.class})
public class MemorizeApplication {
	@Autowired
	private IUserService iUserService;

	public static void main(String[] args) {
		SpringApplication.run(MemorizeApplication.class, args);
	}

}
