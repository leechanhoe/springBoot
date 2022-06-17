package dodo.hellospring.controller;

import dodo.hellospring.domain.Member;
import dodo.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 얘는 springConfig에 안넣어도 어차피 컴포넌트 스캔됨 그래서 autowired가능
public class MemberController {

    //@Autowired private MemberService memberService;  필드주입방식
    private final MemberService memberService;

//    public void setMemberService(MemberService memberService) { setter 방식 근데 바꿀일없어서 거의안씀
//    public 이라 열려있어서 불필요하게 호출될수도있음
//        this.memberService = memberService;
//    }

    @Autowired // 스프링 컨테이너에서 멤버서비스를 가져와서 연결  // 생성자 방식
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") // 얘는 조회할때 주로 씀
    public String createForm(){
        return "members/createMemberForm";
    }
    
    @PostMapping("/members/new") // post 는 <form>같은데에 넣어서 전달할때 씀 ,데이타 등록할때 주로 씀
    public String create(MemberForm form){ // 스프링이 <input name = "name" 을 보고 form 에 setName 을 호출해서 저절로 넣어줌>
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        
        return "redirect:/"; // 홈화면으로 보내기
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers(); // findMembers 는 멤버 다 끌어옴
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
