<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>목록</title>
  <meta http-equiv="X-UA_Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type='text/css' media='screen' href="${pageContext.request.contextPath}/resources/insert.css">
</head>


<body>
  <section class="wrap">
    <form action="search_action">
      <label> 검색할 직원 이름 :
        <input type="text" name="worker_name" placeholder="이름"  />
      </label> 
      <input type="submit" value="조회하기" />
    </form>
  </section>
</body>

</html>
