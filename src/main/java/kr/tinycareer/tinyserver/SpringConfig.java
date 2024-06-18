package kr.tinycareer.tinyserver;

import kr.tinycareer.tinyserver.repository.MemberRepository;
import kr.tinycareer.tinyserver.repository.MemoryMemberRepository;
import kr.tinycareer.tinyserver.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
};
