package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

// 년월일을 입력하면 요일을 알려주는 프로그램
@RestController
public class YoilTeller {
    @RequestMapping("/getYoil")
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 입력받는 부분
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        // 2. 작업 - 요일을 계산
        Calendar cal = Calendar.getInstance();  //현재 날짜와 시간을 갖는 cal
        cal.clear(); //cal 의 모든 필드를 초기화
        cal.set(yyyy, mm - 1, dd); // mm은 0~11이므로 -1을 해줘야 함.

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1~7을 반환 1: 일요일, 2:월요일...
        char yoil = "일월화수목금토".charAt(dayOfWeek-1); // 1~7 -> 0~6으로 변환


        //3. 출력 - 작업결과를 브라우져에 전송
        response.setCharacterEncoding("ms949");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("year = "+year);
        out.println("month = "+month);
        out.println("day = "+day);
        out.println("yoil = "+yoil);
        out.println("</body>");
        out.println("</html>");

    }
}
