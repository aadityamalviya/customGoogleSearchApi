<%@page import="org.springframework.web.bind.annotation.ResponseBody"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="application/json; charset=UTF-8">
<title>Test: hello</title>
</head>
<body>
	<h1>Hello, world</h1>
		<html>
  <head>
    <title>Your Title Here</title>
  </head>
  <body>
    <form action="#" method="POST">
      <input type="text" id="searchStr" name="searchStr" />
      <input type="submit" value="Submit" />
      
   <c:forEach var="getall" items="${getall}">
    <c:forEach var="items" items="${getall}">
 	 <c:forEach var="title" items="${getall}">
            

     <h5>${getall.items}</h5>
 	</c:forEach>
   </c:forEach>
</c:forEach>
    </form>
  </body>
</html>
</body>
</html>