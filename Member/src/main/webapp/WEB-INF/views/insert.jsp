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
    <form action="insert_action">
      <label> 이름 입력 :
        <input type="text" name="worker_name" placeholder="이름"  />
      </label>
      <label> 성별 입력 : 
        <input type="text" name="sex" placeholder="성별"  />
      </label>
        <label> 주소 입력 :
        <input type="text" name="address" placeholder="주소"  />
      </label>
        <label> 소속부서 입력 :
        <input type="text" name="part" placeholder="소속부서"  />
      </label>
      <input type="submit" value="입력 완료" />
    </form>
  </section>
</body>

</html>
