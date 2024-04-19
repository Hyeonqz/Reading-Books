package org.example.service.web.controller;

import org.assertj.core.api.Assertions;
import org.example.service.domain.posts.PostRepository;
import org.example.service.web.dto.request.PostsSaveRequestDto;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsApiControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private PostRepository postRepository;

	@After
	public void tearDown () throws Exception {
		postRepository.deleteAll();
	}

	@Test
	void save () throws Exception {
		String title = "title";
		String content = "content";
		PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
			.title(title)
			.content(content)
			.author("author")
			.build();

		String url = "http://localhost:"+port+"/api/v1/posts";

		ResponseEntity<Long> responseEntity = testRestTemplate
			.postForEntity(url, requestDto, Long.class);

		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK);
	}

}