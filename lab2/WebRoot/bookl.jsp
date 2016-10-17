<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java"
	import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'bookl.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table align="center" border="1" style="width:80%;">
		<tr>
			<th colspan="10" align="center">详细信息</th>
		</tr>
		<tr>
			<td>书名</td>
			<td>ISBN号</td>
			<td>作者</td>
			<td>作者ID</td>
			<td>作者年龄</td>
			<td>作者国籍</td>
			<td>出版社</td>
			<td>出版时间</td>
			<td>价格</td>
			<td>操作</td>

		</tr>
		<tr>
			<td><s:property value="book.Title" /></td>
			<td><s:property value="book.ISBN" /></td>
			<td><s:property value="author.Name" /></td>
			<td><s:property value="book.AuthorID" /></td>
			<td><s:property value="author.Age" /></td>
			<td><s:property value="author.Country" /></td>
			<td><s:property value="book.Publisher" /></td>
			<td><s:property value="book.PublishDate" /></td>
			<td><s:property value="book.Price" /></td>
			<td><a href="bookdel.action?bkID=${book.ISBN}">删除</a></td>
		</tr>
	</table>
	<form action="index.jsp" method="post">
		<input type="submit" value="Return" />
	</form>
</body>
</html>
