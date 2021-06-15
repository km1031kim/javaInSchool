<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>입주자 정보 등록</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='${pageContext.request.contextPath}/resources/insert.css'>
</head>
<body>
    <section class="wrap">
    <h1>아파트 정보</h1>
        <form action="apart_insert" method="get">
            <label> 아파트 이름
              <br> 
                <input type="text" name="name" placeholder="이름" />
            </label>
            
            <input type="submit" value="Sign Up" />
            <br>
        <a href="/kopo" style="margin-top: 50px;">홈으로</a>
        </form>
        
    </section>
</body>
</html>