package org.example.service.web.dto.response;

import java.time.LocalDateTime;

import org.example.service.domain.posts.Posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostsListResponseDto {
	private Long id;
	private String title;
	private String author;
	private LocalDateTime modifiedDate;

	public PostsListResponseDto (Posts posts) {
	}

}
