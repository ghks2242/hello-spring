package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    url 이없는데 index.html을 안가는 이유는 요청이오면 spring 컨테이너를 먼저 찾고 관련이없으면 static을 찾는다.
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
