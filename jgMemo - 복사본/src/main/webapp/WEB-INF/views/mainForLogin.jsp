<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Main</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='${pageContext.request.contextPath}/resources/main.css'>
</head>
<body  bgcolor = #91A8d0   >
<br>
    <center>
    <h1>HELLO!</h1>
    <h2>WELCOME TO JAVA WORLD</h2>
  </center>

    <section class="wrap">
        <a href="updateInfo">회원정보 수정</a>
        <a href="create">CREATE TABLE(테이블 생성)</a>
        <a href="insertMemo">메모 입력</a>
        <a href="list">메모 보기</a>
        <a href="logout">LOG OUT</a>
    </section>
 
</body>
</html>