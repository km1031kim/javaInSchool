<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>회원 가입</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='${pageContext.request.contextPath}/resources/insert.css'>
</head>
<body>
    <section class="wrap">
    <h1>Memo</h1>
        <form action="memo_insert" method="post">
            <label> 제목
            <br> 
                <input type="text" name="subject" placeholder="제목" />
            </label>
         	  <label>
			<textarea name="contents" cols="83" rows="20" placeholder="내용을 입력하세요"></textarea>
			  </label>	

            <input type="submit" value="Sign Up" />
            <br>
        <a href="/jg" style="margin-top: 50px;">홈으로</a>
        </form>
        
    </section>
</body>
</html>