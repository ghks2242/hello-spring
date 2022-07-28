package hello.hellospring;

import hello.hellospring.repository.MemberRespository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // #1
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    // #2
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    // #3
    private final MemberRespository memberRespository;

    @Autowired
    public SpringConfig(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRespository);
    }

//    @Bean
//    public MemberRespository memberRespository() {
        // #1
//        return new MemoryMemberRespository();
        // #2
//        return new JpaMemberRepostiory(em);

//    }
    /*
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/
}
