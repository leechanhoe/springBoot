package dodo.hellospring.controller;

import dodo.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 얘는 springConfig에 안넣어도 어차피 컴포넌트 스캔됨 그래서 autowired가능
public class MemberController {

    //@Autowired private MemberService memberService;  필드주입방식
    private final MemberService memberService;

//    public void setMemberService(MemberService memberService) { setter 방식 근데 바꿀일없어서 거의안씀
//    public 이라 열려있어서 불필요하게 호출될수도있음
//        this.memberService = memberService;
//    }

    @Autowired // 스프링 컨테이너에서 멤버서비스를 가져와서 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
