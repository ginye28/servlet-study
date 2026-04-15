package com.example.servletstudy.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/api/accounts")
public class AccountController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");  //encoding을 먼저 해줘야함 (요청과 동시에 값이 들어오기 때문에 읽어야 함)     UTF-8(한글)
        System.out.println("요청들어옴!!!!!!");
        BufferedReader bufferedReader = req.getReader(); //요청에 들어온걸 읽음
        StringBuilder stringBuilder = new StringBuilder();
        String line = null; //밑에서 여기로 대입
        while ((line = bufferedReader.readLine()) != null) { //null일 때까지 반복
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder);
    }
}

