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
    <h1>입주자 정보 등록</h1>
        <form action="insert_action" method="post">
            <label> 이름
            <br> 
                <input type="text" name="name" placeholder="이름" />
            </label>
            <label> 나이
            <br> 
                <input type="text" name="age" placeholder="숫자로 입력해주세요" />
            </label>
            <label> 성별
            <br> 
                <input type="text" name="sex" placeholder="남/여 중 하나로 적어주세요" />
            </label>
            
             <label> 아파트
            <br> 
                <input type="text" name="apart" placeholder="현재 아파트 목록 = ${apartNameList }" />
            </label>
         
            <input type="submit" value="Sign Up" />
            <br>
        <a href="/kopo" style="margin-top: 50px;">홈으로</a>
        </form>
        
    </section>
</body>
</html>