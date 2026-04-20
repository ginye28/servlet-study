package com.example.servletstudy.login;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")  //톰캣이 이 URL로 들어오면 doFilter가 실행되게 함      web.xml에 filter 순서를 정해줌
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");       //전체 경로를 사용 먼저 실행됨
        servletResponse.setCharacterEncoding("UTF-8");          //CharacterEncoding  문자열 변환
        filterChain.doFilter(servletRequest, servletResponse);
    }
}