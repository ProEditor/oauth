package com.proeditor.visa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@RestController
public class App {
	@RequestMapping(value = "/home")
	public String home() {
		return "Hello Spring";
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("Hello World!");
		Logger logger = LoggerFactory.getLogger("chapters.configuration");
		logger.info("info");
		logger.error("error");
		logger.debug("debug");
		LoggerContext context=(LoggerContext)LoggerFactory.getILoggerFactory(); 
		StatusPrinter.print(context);
	}
}
