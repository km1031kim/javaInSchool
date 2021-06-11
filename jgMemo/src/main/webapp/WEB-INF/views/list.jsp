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
    <input type="hidden" name=${userIdx } />
        <table>
            <thead>
                <tr>
                    <th>IDX</th><th>title</th><th>content</th><th>created</th><th>updated</th><th>수정하기</th><th>삭제하기</th>
                </tr>
            </thead>
            <tbody>
				${list }
            </tbody>
        </table>
        <br>
        <a href="/login" style="margin-top: 50px;">홈으로</a>
    </section>
    
</body>
</html>