<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>목록</title>
  <meta http-equiv="X-UA_Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type='text/css' media='screen' href="${pageContext.request.contextPath}/resources/list.css">
</head>


<body>
  <section class="wrap">
    <table>
      <thead>
      	<th>index</th><th>name</th><th>sex</th><th>address</th><th>part</th>
      	</thead>
      	<tbody>
        ${list}
      </tbody>
      </table>
  </section>
</body>

</html>

