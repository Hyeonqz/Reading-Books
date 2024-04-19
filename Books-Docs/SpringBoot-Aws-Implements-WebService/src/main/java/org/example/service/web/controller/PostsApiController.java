package org.example.service.web.controller;

import org.example.service.service.PostsService;
import org.example.service.web.dto.response.PostsResponseDto;
import org.example.service.web.dto.request.PostsSaveRequestDto;
import org.example.service.web.dto.request.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

	private final PostsService postsService;

	@PostMapping("/api/v1/posts")
	public Long save (@RequestBody PostsSaveRequestDto requestDto) {
		return postsService.save(requestDto);
	}

	@PutMapping("/api/v1/posts/{id}")
	public Long update (@PathVariable final Long id,
		@RequestBody PostsUpdateRequestDto postsUpdateRequestDto) {
		return postsService.update(id, postsUpdateRequestDto);
	}

	@GetMapping("/api/v1/posts/{id}")
	public PostsResponseDto findById (@PathVariable Long id) {
		return postsService.findById(id);
	}

}
