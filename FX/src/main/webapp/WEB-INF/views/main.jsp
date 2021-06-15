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
        <a href="createResidentTable">입주자 테이블 생성</a>
        <a href="insert">입주자 정보 등록</a>
        <a href="residentList">입주자 리스트 출력</a>
        <a href="createApartmentTable">아파트 테이블 생성</a>        
        <a href="insertApart">아파트 정보 등록</a>   
        <a href="apartList">아파트 리스트 출력</a>  
        <a href="avg">입주자 통계 출력</a>
        <a href="apartAvg">아파트 통계 출력</a>
        
    </section>
 
</body>
</html>