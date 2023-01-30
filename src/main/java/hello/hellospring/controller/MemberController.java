package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //springContainer에 컨트롤러를 생성해 넣어두고 관리한다. //spring bean이 관리한다.
public class MemberController {

    private final MemberService memberService; //springContainer에 등록
    @Autowired //srpingContainer에 멤버 서비스랑 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }



}
