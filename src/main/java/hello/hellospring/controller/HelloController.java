package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러 어노테이션
public class HelloController {

    /*
    * 요청이 들어오면 내장 톰캣서버가 url을 매칭, controller에 있는 메서드가 실행
    * */
    @GetMapping("hello") //webapp에서 /hello로 들어오면 호출됨
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //기본적으로 /resource/templates에 있는 hello.html을 찾아 렌더링
        //resources:templates/ + {viewName} + .html
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){
        //required = true 기본으로 값을 넘겨야함.
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //html에 나오는 body 태그가 아닌 https(header부와 body부로 나뉨) body에 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name ; // "hello spring" 요청한 문자가 클라이언트에 그대로 내려감.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        //현재 구문 완성(Complete Current Statement) 단축키 : ctrl + shift + enter
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 return
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
