<%@page import="com.tzs.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="w" uri="http://www.mytag.com/tags/pager"%>
<%@ taglib prefix="myfn" uri="http://www.mytag.com/jsp/myfn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理系统</title>
<!-- 把上下文路径，放到域里面去 -->
<c:set value="${pageContext.request.contextPath }" var="ctx" scope="application"></c:set>

<script type="text/javascript">
	var ctx = '${ctx}';
</script>

<script type="text/javascript" src="${ctx }/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx }/js/tips.js"></script>
<link rel="stylesheet" href="${ctx }/css/common.css">

<style type="text/css">
.head {
	height: 40px;
	background-color: purple;
	margin-bottom: 5px;
	width: 1200px;
	margin: 0px auto;
	border: 2px solid purple;
	line-height: 40px;
}

.head .title{
	 font-size: 24px;
	 font-weight: bold;
	 color: white;
}

.user-info {
	float: right;
	color: white;
}
</style>
</head>
<body>
	<div class="head">
		<div class="user-info">
			用户名:${loginUser.real_name}
			<a href="${ctx }/logout" >退出</a>
		</div>
		<div class="title">
			用户系统
		</div>

	</div>
</body>
</html>