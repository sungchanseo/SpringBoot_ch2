package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
    @RequestMapping("/getYoil")
    public String main(@ModelAttribute MyDate myDate, Model model) throws IOException {

        // 2. 작업 - 요일을 계산
        char yoil = getYoil(myDate);

        //작업한 결과를 model에 저장해서 전달 -> @ModelAttribute를 사용하면 불필요해진다.
//        model.addAttribute("myDate", myDate);
//        model.addAttribute("year", myDate.getYear());
//        model.addAttribute("month", myDate.getMonth());
//        model.addAttribute("day", myDate.getDay());
//        model.addAttribute("yoil", yoil);

        return "yoil";
    }

    @ModelAttribute("yoil")
    private char getYoil(MyDate myDate) {
        Calendar cal = Calendar.getInstance();  //현재 날짜와 시간을 갖는 cal
        cal.clear(); //cal 의 모든 필드를 초기화
        cal.set(myDate.getYear(), myDate.getMonth() - 1, myDate.getDay()); // mm은 0~11이므로 -1을 해줘야 함.

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1~7을 반환 1: 일요일, 2:월요일...
        char yoil = "일월화수목금토".charAt(dayOfWeek-1); // 1~7 -> 0~6으로 변환
        return yoil;
    }
}
