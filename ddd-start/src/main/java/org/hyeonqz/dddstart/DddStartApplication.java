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
		log.info("도메인 주도 개발 시작해보자고~~");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main (String[] args) {
		SpringApplication.run(DddStartApplication.class, args);
	}

}
