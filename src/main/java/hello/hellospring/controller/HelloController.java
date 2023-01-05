package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //컨트롤러 어노테이션
public class HelloController {

    /*
    * 요청이 들어오면 내장 톰캣서버가 url을 매칭, controller에 있는 메서드가 실행
    * */
    @GetMapping("hello") //webapp에서 /hello로 들어오면 호출됨
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //templates에 있는 hello.html을 찾아 렌더링
        //resources:templates/ + {viewName} + .html
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){
        //required = true 기본으로 값을 넘겨야함.
        model.addAttribute("name", name);
        return "hello-template";
    }
}
