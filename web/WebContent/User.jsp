<%@page import="cn.tzs.demo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
		User user = new User("唐大夫","dddfdf");
	%>
	用户名:<%=user.getName()%>
	 密码：<%=user.getPassword() %>
</body>
</html>