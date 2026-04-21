package com.example.servletstudy.login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

//@WebFilter("/*")     //모든 요청에 필터를 거침
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        ((HttpServletRequest) servletRequest).getSession(); //http로 다운캐스팅 해줘야 함     http를 사용하기 때문
        HttpServletRequest httpReq = (HttpServletRequest) request;


        String uri = httpReq.getRequestURI();
        String projectNameIgnoreUri = uri.substring(uri.indexOf("/", 1));       //1번 index부터 uri를 찾음


        if (projectNameIgnoreUri.startsWith("/api/auth")       //이 줄이 없으면 로그인을 로그인 해야 쓸 수 있음
                || projectNameIgnoreUri.startsWith("/api/html")) {
            chain.doFilter(request, response);
            return;    //갔다가 돌아올 때 밑에 줄이 실행되니 return
        }


        HttpSession session = httpReq.getSession();
        Object authAttribute = session.getAttribute("authentication");      //set
        if (authAttribute == null) {           //authAttribute가 null이면 로그인이 안된 상태
            ResponseEntity.builder()
                    .status(403)
                    .body("로그인 후 이용가능합니다.")
                    .build()
                    .response(response); //변수랑 메서드 구분하기
            return;  //여기서 다음으로 넘어가면 필터라서 못 넘어가게 만들어줘야 함 (return)
        }

        chain.doFilter(request, response);
    }
}
