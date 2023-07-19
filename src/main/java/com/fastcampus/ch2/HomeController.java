package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

//1. 원격프로그램으로 먼저 등록 -> @Controller 어노테이션 추가
//2. URL과 메소드를 연결 -> @RequestMapping
@Controller
public class HomeController { //원격프로그램


    @RequestMapping("/")
    public String main(){
        System.out.println("hello");
        return "index"; // template/index.html 보통 메인페이지를 index.html로 한다.
    }

    @GetMapping("/test")
    public String test(Model model, HttpServletRequest request){
        request.setAttribute("year", 2023); //request 객체에 저장

        HttpSession session = request.getSession();
        session.setAttribute("id", "asdf");

        ServletContext application = session.getServletContext();
        application.setAttribute("email", "sss@naver.com");

        model.addAttribute("lastName", "SEO");
        model.addAttribute("firstName", "SUNG CHAN");
        model.addAttribute("list", Arrays.asList("aaa", "bbb", "ccc", "ddd"));
        model.addAttribute("bno", "1234");
        model.addAttribute("user", new User("aaa", 20));
        return "test"; // template/test.html
    }
}
