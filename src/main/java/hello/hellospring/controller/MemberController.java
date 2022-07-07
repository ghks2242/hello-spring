package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 스프링컨테이너가 뜰때 Controller 어노테이션이있으면 객체를 생성
public class MemberController {

    private final MemberService memberService;

//    DI (디펜던스인젝션) 의 주입방법은 3가지 밑에 예시를 통해 생성자에 @Autowired 붙이는방법
//    필드에 주입하는방법 @Autowired  private final MemberService memberService;
//    세터주입 이있다 이방법의 단점은 public 이라 누군가가 호출해서 바꿀위험이있다
//    의존관계가 실행중에 동적으로 변경되는 경우가 거의없으므로 생성자 주입을 쓰는걸 권장한다

//    @Autowired 를 통한 DI 는 스프링이 관리하는객체 에서만 동작한다

    @Autowired // 스프링컨테이너 등록되어있는 아이를 가져온다
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        // 스프링빈을 등록하는 2가지방법
        //      컴포넌트 스캔과 자동 의존관계설정
        //      - @Component 어노테이션이 있으면 스프링 빈으로 자동 등록된다.
        //      - @Controller 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 떄문이다.
        //      - @Component 포함하는 다음 어노테이션도 스프링빈으로 자동등록된다
        //      -- @Controller
        //      -- @Service
        //      -- @Repository
        //      자바 코드로 직접 스프링빈 등록
        //      - SpringConfig 등록

    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";

    }
}
