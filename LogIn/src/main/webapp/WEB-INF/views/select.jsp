<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>데이터 입력</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='${pageContext.request.contextPath}/resources/select.css'>
</head>
<body>
    <section class="wrap">
     <h1>SEARCH DATA</h1>
        <form action="select_action">
           <label> PLEASE ENTER NAME
             <br>
             <br>
             <input type="text" name="name" placeholder="NAME" />
             </label>
            <input type="submit" value="입력 완료" />
        </form>
    </section>
</body>
</html>