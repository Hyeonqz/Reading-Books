package org.example.service.domain.posts;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass //다른 엔티티가 이 클래스 상속할 경우, 컬럼을 인식하도록 함
@EntityListeners(AuditingEntityListener.class) // Auditing 기능을 포함시킨다.
public class BaseTimeEntity {

	// @EnableJpaAuditing // JPA Auditing 활성화를 시켜야함 메인 클래스에서

	@CreatedDate
	private LocalDateTime createAt;

	@LastModifiedDate
	private LocalDateTime updateAt;
}
