package com.example.servletstudy.login;

import com.fasterxml.jackson.core.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/api/auth/signin") //auth = AuthenticationController
public class AuthenticationController extends HttpServlet {

    private User loginUser = User.builder()
            .id(1)
            .username("abcd")
            .password("1234")
            .name("진혜정")
            .build();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonParserUtil.getJson(req);
        Map<String, Object> requestBody = JsonParserUtil.parse(json);
        System.out.println(requestBody);
        if (!loginUser.getUsername().equals(requestBody.get("username"))) {
            errorResponse(reap, "사용자 정보가 일치하지 않습니다.");
        }
    }

    //응답 json으로 함       객체인데 json으로 바뀜
    private void errorResponse(HttpServletResponse resp, String message) throws IOException {
        resp.setStatus(403);  //인증실패(권한 없음)
        resp.setContentType("application/json");
        Map<String, Object> responseMap = Map.of(
                "code", 403,
                "message", message
        );
        resp.getWriter().println(JsonParserUtil.stringify());
    }

}
