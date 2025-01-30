package org.hyeonqz.dddstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class DddStartApplication {

	@PostConstruct
	public void init() {
		log.info("도메인 주도 개발 시작하기!");
	}

	public static void main (String[] args) {
		SpringApplication.run(DddStartApplication.class, args);
	}

}
