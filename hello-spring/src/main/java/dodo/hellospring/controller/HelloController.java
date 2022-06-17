package dodo.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // 얘는 화면을 템플릿 엔진에서 조작함
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // API 방식 - http 에 헤더부 바디부가 있는데 응답 바디부에 내용을 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // 얘는 화면이 view 를 안거치고 그대로 감
    }

    @GetMapping("hello-api") // API 방식 보통은 실무에서 이렇게함
    @ResponseBody // 요즘은 기본으로 json으로 반환
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); // 자동완성 : ctr + shift + Enter
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name; // Get Set 생성 단축키는 alt + insert

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
