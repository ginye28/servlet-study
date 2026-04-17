package com.example.servletstudy.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/products")
public class ProductController extends HttpServlet {

    @Override      //productController를 읽음
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //오류가 터지면 서버가 닫히니까 예외처리 해줌
        resp.getWriter().println("상품 조회 완료");                                //uncheck           check    http://의 입력 오류
    }
}
