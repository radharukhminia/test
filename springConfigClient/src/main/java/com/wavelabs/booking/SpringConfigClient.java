package com.wavelabs.booking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@SpringBootApplication
public class SpringConfigClient {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClient.class, args);

	}
}

@RefreshScope
@RestController
@ConfigurationProperties("user")
class MessageRestController {

	@Value("${user.name}")
	 String name;

	@RequestMapping("/msg")
	String getMsg() {
		return this.name;
	}
}
