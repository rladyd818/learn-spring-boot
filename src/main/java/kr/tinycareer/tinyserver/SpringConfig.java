package kr.tinycareer.tinyserver;

import kr.tinycareer.tinyserver.repository.JdbcMemberRepository;
import kr.tinycareer.tinyserver.repository.MemberRepository;
import kr.tinycareer.tinyserver.repository.MemoryMemberRepository;
import kr.tinycareer.tinyserver.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
};
