<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Find by Author</title>
</head>
<body>
   <form action="authorse" method="post">
      <big><strong>Input Authorname:</strong></big><br/><input type="text" name="authorname" style="height: 25px; width: 187px; "/><br/>
      <input type="submit" value="Search" style="height: 27px;;"/>		
   </form>
   <form action=add.jsp method="post">
      <input type="submit" value="Add new Book" style="width: 106px; "/>		
   </form>
   <form action="bookshow" method="post">
      <input type="submit" value="Show All of Book" style="width: 129px; "/>		
   </form>
</body>
</html>