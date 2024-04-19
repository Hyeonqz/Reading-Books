package org.example.service.web.dto.response;

import org.example.service.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsResponseDto {

	private Long id;
	private String title;
	private String content;
	private String author;

	// entity의 일부만 사용 한다. 생성자가 entity 를 받아 필드에 값을 넣는다.
	public PostsResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getAuthor();
	}
}
