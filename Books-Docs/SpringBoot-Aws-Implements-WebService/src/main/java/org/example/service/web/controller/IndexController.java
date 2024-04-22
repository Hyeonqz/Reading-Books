package org.example.service.web.controller;

import org.example.service.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {

	private final PostsService postsService;

	@GetMapping("/")
	public String index (Model model) { // 서버 템플릿 엔지에서 사용할 수 있는 객체를 저장한다.
		model.addAttribute("posts", postsService.findAllDesc());
		return "index";
	}

	@PutMapping("/posts/update/{id}")
	public String postsUpdate (@PathVariable Long id, Model model) {
		var dto = postsService.findById(id);
		model.addAttribute("dto",dto);

		return "posts-update";
	}

	@DeleteMapping("/api/v1/posts/{id}")
	public Long delete(@PathVariable Long id) {
		postsService.delete(id);
		return id;
	}

}
