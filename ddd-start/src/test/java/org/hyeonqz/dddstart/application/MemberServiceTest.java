package org.hyeonqz.dddstart.application;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.hyeonqz.dddstart.DddStartApplication;
import org.hyeonqz.dddstart.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = DddStartApplication.class)
class MemberServiceTest {

	@Autowired
	private MemberService memberService;

	@Test
	@DisplayName("Member 를 조회한다.")
	void findMemberTest() {
	    // given
		Long id = 2839823L;

	    // when
		Member member = memberService.findMember(id);

		// then
		Assertions.assertThat(member).isNotNull();
	}

}