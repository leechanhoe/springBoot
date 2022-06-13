package dodo.hellospring;

import dodo.hellospring.repository.*;
import dodo.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }
//    private DataSource dataSource;
//
//    @Autowired

    @Bean // 스프링빈에
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }등록하라는뜻
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
//}
