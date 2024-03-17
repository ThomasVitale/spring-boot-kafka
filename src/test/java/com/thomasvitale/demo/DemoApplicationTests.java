package com.thomasvitale.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestDemoApplication.class)
class DemoApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void contextLoads() {
		webTestClient
				.post()
				.uri("/")
				.bodyValue(new Instrument("piano"))
				.exchange()
				.expectStatus().isOk()
				.expectBody(Skill.class).value(skill -> {
					assertThat(skill.content()).isEqualTo("I play the PIANO");
				});
	}

}
