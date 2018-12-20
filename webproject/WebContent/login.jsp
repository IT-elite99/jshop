<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<c:set value="${pageContext.request.contextPath }" var="ctx"
	scope="application"></c:set>
<script type="text/javascript">
	var ctx = '${ctx}';
</script>
<style type="text/css">
	.loginDiv {
	width: 444px;
	margin: 0px auto;
	border: 1px solid purple;
}

.title {
	background-color: purple;
	height: 40px;
	font-size: 24px;
	line-height: 40px;
	color: white;
	text-indent: 2em;
	font-weight: bold;
}

.loginDiv table td {
	height: 40px;
}

.loginDiv table td.td_title {
	width: 150px;
	text-align: right;
}

.loginDiv table td input {
	height: 25px;
}

.loginDiv table td img {
	vertical-align: middle;
}

.loginDiv table td input[name=code] {
	width: 80px;
}
</style>

</head>
<body>

	<div class="loginDiv">
		<div class="title">用户登陆</div>
		<form action="login">
			<table class="">
				<tr>
					<td class="td_title">用户名：</td>
					<td><input name="real_name" placeholder="用户名" autocomplete="off"></td>
				</tr>
				<tr>
					<td class="td_title">密码：</td>
					<td><input name="password">
				</tr>
				<tr>
					<td class="td_title">验证码：</td>
					<td><input name="code"> <img class="code" alt=""
						id="img" style="cursor: pointer;" title="刷新图片"
						src="${ctx }/AuthImage"></td>
				<tr>
					<td class="td_title"><input type="submit" value="登陆"></td>
					<td><input type="reset" value="取消"></td>
				</tr>

				<tr>
					<td></td>
					<td>
						<p style="color: red">
							${message }
						</p>
					</td>
			</table>
		</form>
	</div>
</body>

<script type="text/javascript">
	document.getElementById("img").onclick = function() {
		
		this.src = ctx+"/AuthImage?" + new Date().getTime();

	}
</script>
</html>