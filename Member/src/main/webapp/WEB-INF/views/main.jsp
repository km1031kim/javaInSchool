<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<html>
<head>
	<meta charset="utf-8">
  <title>Main</title>
  <meta http-equiv="X-UA_Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type='text/css' media='screen' href="${pageContext.request.contextPath}/resources/main.css">
  
</head>
<body>
<section class = "wrap">
<a href="create">직원 명부 생성</a>
<a href="insert">직원 입력</a> 
<a href="list">직원 목록 전체 조회</a> 
<a href="search">직원 조회</a> 



</section>
</body>
</html>
