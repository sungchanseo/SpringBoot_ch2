package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//1. 원격프로그램으로 먼저 등록 -> @Controller 어노테이션 추가
//2. URL과 메소드를 연결 -> @RequestMapping
@Controller
public class HomeController { //원격프로그램


    @RequestMapping("/")
    public String main(){
        System.out.println("hello");
        return "index"; // template/index.html 보통 메인페이지를 index.html로 한다.
    }
}
