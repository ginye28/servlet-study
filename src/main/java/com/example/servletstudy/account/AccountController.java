package com.example.servletstudy.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/api/accounts")
public class AccountController extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Delete 요청 들어옴");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Put 요청 들어옴");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get 요청 들어옴");
        String p1 = req.getParameter("age");
        String p2 = req.getParameter("address");
        String p3 = req.getParameter("year");
        String[] p4 = req.getParameterValues("ages");
        Map<String, String[]> p5 = req.getParameterMap();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(Arrays.toString(p4));
        System.out.println(p5.entrySet());
        System.out.println(p5.entrySet().stream()
                .map(entry -> Map.of(entry.getKey(), Arrays.asList(entry.getValue())))
                .toList());                                 //asList 이 배열을 List로 만들어줌
        System.out.println(p5.keySet());  //key값을 다 알지 못 하면 map     //뭔지도 모를 값이 들어오면 400 나올 수도 있음  그래서 param을 많이 씀
        String[] p5Values = p5.get("year");
        String p5Value = p5.get("year")[0];     //String p3 = req.getParameter("year"); 이거랑 같음
        req.setAttribute("name", "진혜정");
        req.getRequestDispatcher("/account.jsp").forward(req, resp);
        String hostHeader = req.getHeader("Host");
        System.out.println(hostHeader);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("요청들어옴!!!!!!");
        BufferedReader bufferedReader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder);
    }
}

