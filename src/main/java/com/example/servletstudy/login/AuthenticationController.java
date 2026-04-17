package com.example.servletstudy.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

// 기능적인 걸 제외하면 도메이
@WebServlet("/api/auth/signin") //auth = AuthenticationController          mapping 됨 (web.xml에 설정 안 해줘도 됨)
public class AuthenticationController extends HttpServlet {

    private User loginUser = User.builder()
            .id(1)
            .username("abcd")
            .password("1234")
            .email("abc@gmail.com")
            .build();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonParserUtil.getJson(req);
        Map<String, Object> requestBody = JsonParserUtil.parse(json);
        System.out.println(requestBody);
        if (!loginUser.getUsername().equals(requestBody.get("username"))) {     //null인지 확인
            ResponseEntity.builder()
                    .status(403)
                    .body("사용자 정보가 일치하지 않습니다.")
                    .build()
                    .response(resp);
            return;
        }

        if (!loginUser.getPassword().equals(requestBody.get("password"))) {      //웬만하면 오류를 걸러내고 밑에 정상 코드 작성하기
            ResponseEntity.builder()
                    .status(403)
                    .body("사용자 정보가 일치하지 않습니다.")
                    .build()
                    .response(resp);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("authentication", loginUser);
        ResponseEntity
                .builder()
                .status(200)
                .body("로그인 완료!")
                .build()
                .response(resp);

    }
}
