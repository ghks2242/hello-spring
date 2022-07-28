package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component  // 컴포넌트 스캔으로 빈에등록시킬수도있지만 AOP 는 특별한 클래스이므로 스프링컨피그에서 빈으로 등록하는것을 추의
public class TimeTraceAop {

//
//    AOP 의장점 핵심관심사항을 깔끔하게 유지할수있다
//    핵심관심사항과 공통관심사항을 분리한다
//    변경이 필요하면 이로직만수정하면된다
//    원하는적용대상을 선택할수있다
//

//    AOP 동작방식
//    ex) service 만적용시켯다고 예시를들면 helloController > memberService(프록시) > memberService
//    적용한곳에 가짜 맴버서비스 프록시를 만듬 그후 proceed() 함수이후에 진짜 맴버서비스를 호출

    // AOP 를 어디에다가 적용시킬것인지
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: " + proceedingJoinPoint.toString());
        try {
            return proceedingJoinPoint.proceed(); // 다음메소드로 진행
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + proceedingJoinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
