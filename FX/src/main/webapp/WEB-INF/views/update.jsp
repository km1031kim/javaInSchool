<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>입주자 정보 수정</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='${pageContext.request.contextPath}/resources/insert.css'>
</head>
<body>
    <section class="wrap">
    
    <h1>입주자 정보 수정</h1>
        <form action="update_action" method="post">
        <input type = "hidden" name="idx" value="${idx }" />
            <label> 이름
            <br> 
                <input type="text" name="name" value="${name }"  />
            </label>
            <label> 나이
            <br> 
                <input type="text" name="age"  value="${age }"/>
            </label>
            <label> 성별
            <br> 
                <input type="text" name="sex"  value="${sex }" />
            </label>
            
            
            
            
            
             
         
         
            <input type="submit" value="Sign Up" />
            <br>
        <a href="/kopo" style="margin-top: 50px;">홈으로</a>
        </form>
        
    </section>
</body>
</html>