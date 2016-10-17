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

<title>My JSP 'success.jsp' starting page</title>

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
	<table>
		<td>
			<table>
				<tr>
					<th>图书信息</th>
				</tr>
				<tr>
					<td>书名</td>
					<td>ISBN号</td>
					<td>作者ID</td>
					<td>价格</td>
					<td>出版社</td>
					<td>出版时间</td>
				</tr>
				<s:iterator value="booklist">
					<tr>
						<td><a href="bookget.action?BookID=${ISBN}"><s:property
									value="Title" /></a></td>
						<td><s:property value="ISBN" /></td>
						<td><s:property value="AuthorID" /></td>
						<td><s:property value="Price" /></td>
						<td><s:property value="Publisher" /></td>
						<td><s:property value="PublishDate" /></td>
						<td><s:property value='%{authorlist[#]}' /></td>
					</tr>
				</s:iterator>
			</table>
		</td>
		<td>
			<table>
				<tr>
					<th>作者信息</th>
				</tr>
				<tr>
					<td>作者姓名</td>
					<td>作者年龄</td>
					<td>作者国籍</td>
				</tr>
				<s:iterator value="authorlist">
					<tr>
						<td><s:property value="Name" /></td>
						<td><s:property value="Age" /></td>
						<td><s:property value="Country" /></td>
					</tr>
				</s:iterator>
			</table>
		</td>
	</table>
	<form action="index.jsp" method="post">
		<input type="submit" value="Return" />
	</form>
</body>
</html>
