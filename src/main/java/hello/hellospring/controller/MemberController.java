package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //springContainer에 컨트롤러를 생성해 넣어두고 관리한다. //spring bean이 관리한다.
public class MemberController {

    private final MemberService memberService; //springContainer에 등록
    @Autowired //srpingContainer에 멤버 서비스랑 연결 //의존관계를 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 스프링 빈을 등록하는 2가지 방법
     * 1. 컴포넌트(@Component 있으면 스프링 빈으로 자동 등록) 스캔과 자동의존관계 설정
     * 2. 자바 코드로 직접 스프링 빈 등록하기
     * */


}
