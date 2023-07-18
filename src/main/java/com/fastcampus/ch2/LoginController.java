package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URLEncoder;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
//    @RequestMapping("/login")


    @GetMapping(value="/login")
    public String showLogin(){
        System.out.println("showLogin() 호출!");
        return "login";
    }
//    @RequestMapping(value="/login/login", method = RequestMethod.POST)
//    @RequestMapping(value="/login/login", method = {ReqeustMethod.GET, RequestMethod.POST}) 하나의 메소드로 둘 다 처리할 때는 배열로!
    @PostMapping(value = "/login")
    public String login(String id, String pw, Model model) throws  Exception{
        //1. id, pw check
        if (loginCheck(id, pw)) {
            model.addAttribute("id", id);
            model.addAttribute("pw", pw);
            return "userInfo";
        }else{
            String msg = URLEncoder.encode("id 또는 pw가 일치하지 않읍니다.", "utf-8");
            return "redirect:/login/login?msg="+msg; //GET방식으로 url 다시쓰기!!
        }
        //2. 일치하면 userInfo.html로 이동 틀리면 login.html로 이동

    }

    private boolean loginCheck(String id, String pw) {
        return id.equals("asdf") && pw.equals("1234");
    }
}
