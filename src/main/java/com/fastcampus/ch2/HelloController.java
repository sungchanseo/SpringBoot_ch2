package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//1. 원격프로그램으로 먼저 등록 -> @Controller 어노테이션 추가
//2. URL과 메소드를 연결 -> @RequestMapping
@RestController
public class HelloController { //원격프로그램


    @RequestMapping("/hello")
    public String main(){
        System.out.println("hello");
        return "/yoil";
    }
}
