package com.msnanda515.PicRecon;

import com.msnanda515.PicRecon.imagemanager.model.Image;
import com.msnanda515.PicRecon.imagemanager.repo.ImageRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PicReconApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PicReconApplication.class, args);
	}
//
//	@GetMapping
//	public String hello() {
//		return "Hello World";
//	}

	@Bean
	CommandLineRunner runner(ImageRepo repo) {
		return args -> {
			Image im = new Image(1);
			repo.insert(im);
		};
	}
}
