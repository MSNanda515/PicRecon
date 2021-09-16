package com.msnanda515.PicRecon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PicReconApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicReconApplication.class, args);
	}

	@GetMapping
	public String hello() {
		return "Hello World";
	}
}
