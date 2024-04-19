package org.example.service.web.dto.request;

import org.example.service.domain.posts.Posts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
	private String title;
	private String content;
	private String author;

	// requestDto 를 엔티티로 바꾸는 과정
	public Posts toEntity() {
		return Posts.builder()
			.title(title)
			.content(content)
			.author(author)
			.build();
	}
}
