package org.example.service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.example.service.domain.posts.PostRepository;
import org.example.service.domain.posts.Posts;
import org.example.service.web.dto.response.PostsListResponseDto;
import org.example.service.web.dto.response.PostsResponseDto;
import org.example.service.web.dto.request.PostsSaveRequestDto;
import org.example.service.web.dto.request.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostsService {
	private final PostRepository postRepository;

	@Transactional
	public Long save (PostsSaveRequestDto postsSaveRequestDto) {
		return postRepository.save(postsSaveRequestDto.toEntity()).getId();
	}

	@Transactional
	public Long update (Long id, PostsUpdateRequestDto postsUpdateRequestDto) {
		Posts post = postRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없다 id= " + id));

		post.update(postsUpdateRequestDto.getTitle(), postsUpdateRequestDto.getContent());
		return id;
	}

	public PostsResponseDto findById (Long id) {
		Posts entity = postRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 게시글 없다 id = " + id));

		return new PostsResponseDto(entity);
	}

	public List<PostsListResponseDto> findAllDesc () {
		return postRepository.findAllDesc().stream()
			.map(PostsListResponseDto::new)// posts -> new PostsListResponseDto(posts))
			.collect(Collectors.toList());
	}

	@Transactional
	public void delete (Long id) {
		var posts = postRepository.findById(id)
			.orElseThrow( () -> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
		postRepository.delete(posts);
	}

}
