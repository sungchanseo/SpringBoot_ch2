package com.fastcampus.ch2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter(urlPatterns = "/*") //모든 요청에 PerformanceFilter를 적용한다.
public class PerformanceFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // 1. 전처리 작업
        long startTime = System.currentTimeMillis();

        //2. 서블릿(콘트롤러) 또는 다음 휠터
        filterChain.doFilter(request, response);


        //3. 후처리 작업
        long endTime = System.currentTimeMillis();
        System.out.print("["+((HttpServletRequest)request).getRequestURI()+"]");
        System.out.println("time = " + (endTime - startTime));

    }
}
