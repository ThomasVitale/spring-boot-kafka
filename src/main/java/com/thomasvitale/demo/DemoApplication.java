package com.thomasvitale.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	Function<Instrument,String> uppercase() {
		return instrument -> {
			log.info("Converting {} to uppercase", instrument.name());
			return instrument.name().toUpperCase();
		};
	}

	@Bean
	Function<String,Skill> sentence() {
		return instrument -> {
			log.info("Building sentence with {}", instrument);
			return new Skill("I play the " + instrument);
		};
	}

}

record Instrument(String name){}

record Skill(String content){}
