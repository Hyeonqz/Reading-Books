package org.example.service.domain.posts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Posts extends BaseTimeEntity{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length=500, nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	private String author;

	@Builder
	public Posts (String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	// @Setter 는 엔티티에서 절대 만들지 않는다.
	// 대신 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 한다.

	// 그러면 setter 가 없는데, 어떻게 값을 DB에 삽입해야 할까요?
	/*
	* 기본적인 구조는 생성자를 통해 최종값을 채운 후 DB에 삽입하는 것이다.
	* 값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하는 것을 전제로 한다.
	* */

	// update 메소드
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}


}
