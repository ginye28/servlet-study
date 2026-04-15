<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        table {
            border: 1px solid #dbdbdb;
            border-collapse: collapse;
        }
        th, td {
            box-sizing: border-box;
            border: 1px solid #dbdbdb;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
    <h1>계좌 생성</h1>
    <button type="button" class="create-button">생성하기</button>
    <table>
        <tr>
            <th>ID</th>
            <th>AccountNo</th>
            <th>Owner</th>
            <th>Balance</th>
        </tr>
        <tr>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
        </tr>
    </table>
    <script> //js를 쓰는 위치, js 타입을 명시하지 않는 언어
        main(); //함수 호출을 함
        function main() {
            const createButton = document.querySelector(".create-button"); //const 변수 선언(final과 비슷함) ,js 자료형 명시 X
                                //문서에서 querySelector를 가지고 옴
            createButton.onclick = () => {
                        //함수명     클래스 생성 + 함수 정의(람다 Override)   온클릭에 정의를 함. 클릭하면 실행한다는 의미
                const inputs = document.querySelectorAll("input");
                                        //input(ID, ACCOUNTNO, OWNER, BALANCE)를 다 가지고 옴
                //private, getter, setter X
                const accountObj = {
                    id: inputs[0].value,
                    accountNo: inputs[1].value,
                    Owner: inputs[2].value,
                    balance: inputs[3].value,
                };
                // fetch함수("매개변수",{매개변수})   객체{} -> new
                fetch("http://localhost:8080/servlet_study_war_exploded/api/accounts", {    //api 요청
                    method: "post",
                    body: JSON.stringify(accountObj),
                    headers: {
                        "Content-Type": "application/json",
                        //Content : 내용(body)        확장자명
                    }
                })
            }//여기까지가 함수 정의
        }
    </script>
</body>
</html>