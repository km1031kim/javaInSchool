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
    <form action="modify_action">
    
    	   <p style="padding: 20px; background: #eee; border-radius: 5px; text-align: center;">
           
            ${name } 님의 성적을 수정합니다
        </p>
      
       
      
       <label> 수정할 중간고사 성적 :
        <input type="text" name="midScore_change" placeholder="중간고사 성적"  />
      </label>
      <label> 수정할 기말고사 성적 :
        <input type="text" name="finScore_change" placeholder="기말고사 성적"  />
      </label>
      <input type="submit" value="입력 완료" />
    </form>
  </section>
</body>

</html>