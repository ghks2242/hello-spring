package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller // 스프링컨테이너가 뜰때 Controller 어노테이션이있으면 객체를 생성
public class MemberController {

    private final MemberService memberService;

    @Autowired // 스프링컨테이너 등록되어있는 아이를 가져온다
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    // 스프링빈을 등록하는 2가지방법
    //      컴포넌트 스캔과 자동 의존관계설정
    //      - @Component 어노테이션이 있으면 스프링 빈으로 자동 등록된다.
    //      - @Controller 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 떄문이다.
    //      - @Component 포함하는 다음 어노테이션도 스프링빈으로 자동등록된다
    //      -- @Controller
    //      -- @Service
    //      -- @Repository
    //      자바 코드로 직접 스프링빈 등록

}
