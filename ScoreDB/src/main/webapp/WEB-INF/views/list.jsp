<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>목록</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='${pageContext.request.contextPath}/resources/list.css'>
</head>
<body>
    <section class="wrap">
        <table>
            <thead>
                <tr>
                    <th>idx</th><th>이름</th><th>중간고사 점수</th><th>기말고사 점수</th><th>생성일</th><th>수정</th><th>삭제</th>
                </tr>
            </thead>
            <tbody>
            	${list }
            </tbody>
        </table>
         <a href="/score" style="margin-top: 50px; " >홈으로</a>
    </section>
</body>
</html>