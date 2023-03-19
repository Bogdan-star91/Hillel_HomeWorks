package com.hillel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
/**
 * @author Bohdan Hrytsai
 * @version 1.0.0
 */

@SpringBootApplication
@EnableScheduling
public class RunApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(RunApplication.class, args);

	}
}
