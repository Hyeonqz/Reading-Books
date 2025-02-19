package org.hyeonqz.dddstart.application;

import org.hyeonqz.dddstart.domain.Member;
import org.hyeonqz.dddstart.infrastructure.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;

}
