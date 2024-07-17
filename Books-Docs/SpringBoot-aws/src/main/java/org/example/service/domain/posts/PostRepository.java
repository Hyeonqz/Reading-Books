package org.example.service.domain.posts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.querydsl.core.annotations.QueryDelegate;

public interface PostRepository extends JpaRepository<Posts, Long> {
	// 위 인터페이스는 엔티티와 같은 위치에 있어야 한다.

	@Query("select p from Posts p ORDER BY p.id desc")
	public List<Posts> findAllDesc();
}

// 조회용 프레임워크 -> QueryDSL
/*
1) 타입 안정성이 보장된다.

2) 국내 많은 회사 사용중
ex) 쿠팡, 배민, 네이버, 카카오 등등

3) 레퍼런스가 많다.
많이 사용하는 만큼, 그에 대한 자료가 많다.
*/