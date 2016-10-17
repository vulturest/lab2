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
	<h1>Add New Book.</h1>
	<s:form action="bookadd">
		<s:textfield name="newTitle" label="书名" />
		<s:textfield name="newISBN" label="ISBN号" />
		<s:textfield name="newAuthorID" label="作者ID" />
		<s:textfield name="newName" label="作者姓名" />
		<s:textfield name="newAge" label="作者年龄" />
		<s:textfield name="newCountry" label="作者国籍" />
		<s:textfield name="newPrice" label="价格" />
		<s:textfield name="newPublishDate" label="出版时间" />
		<s:textfield name="newPublisher" label="出版社" />
		<s:submit value="添加" />
	</s:form>
	
</body>
</html>
