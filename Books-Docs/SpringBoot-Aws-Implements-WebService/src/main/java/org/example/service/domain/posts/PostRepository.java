package org.example.service.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {
	// 위 인터페이스는 엔티티와 같은 위치에 있어야 한다.
}
