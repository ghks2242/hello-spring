package hello.hellospring;

import hello.hellospring.repository.MemberRespository;
import hello.hellospring.repository.MemoryMemberRespository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRespository());
    }

    @Bean
    public MemberRespository memberRespository() {
        return new MemoryMemberRespository();
    }
}
