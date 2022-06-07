package dodo.hellospring;

import dodo.hellospring.repository.MemberRepository;
import dodo.hellospring.repository.MemoryMemberRepository;
import dodo.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean // 스프링빈에 등록하라는뜻
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
