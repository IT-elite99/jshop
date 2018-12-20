
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<%@ include file="/head.jsp"%>
</head>
<script type="text/javascript">
	//自定义正则表达示验证方法
	$.validator.addMethod("checkreal_name", function(value, element, params) {
		var reg = /[\u4e00-\u9fa5_a-zA-Z0-9_]{2,8}/
		return this.optional(element) || (reg.test(value));
	}, "请输入正确的用户名！");

	$.validator.addMethod("checkPwd", function(value, element, params) {
		var reg = /^\S{6,12}$/
		return this.optional(element) || (reg.test(value));
	}, "请输入正确的密码！");

	$(function() {

		//对form1表单进行校验
		$("#addFrom").validate({
			//定义校验规则
			rules : {
				name : {
					required : true,
					checkreal_name : true
				},
				password : {
					required : true,
					checkPwd : true
				},
				birthday : {
					required : true
				}

			},
			//自定义提示信息
			messages : {
				real_name : {
					required : "用户名不能为空",
				},
				password : {
					required : "密码不能为空",
				},
				birthday : {
					required : "出生年月不能为空"
				}

			}

		});

	})
</script>



<body>
	<div class="container">
		<div class="title">新增用户</div>
		<div class="content">
			<form id="addFrom" action="${ctx }/user" method="post">
				<input name="oper" type="hidden" value="add"> <input
					name="token" type="hidden" value="${token}">
				<table>
					<tr>
						<td class="text-right">用户名:</td>
						<td class="text-left"><input name="real_name"></td>
					</tr>

					<tr>
						<td class="text-right">密码:</td>
						<td class="text-left"><input name="password" type="password"></td>
					</tr>

					<tr>
						<td class="text-right">性别:</td>
						<td class="text-left"><label> <input name="sex"
								type="radio" value="1">男
						</label> <label> <input name="sex" type="radio" value="0">女
						</label> <label> <input name="sex" type="radio" value="2">保密
						</label></td>
					</tr>

					<tr>
						<td class="text-right">出生年月:</td>
						<td class="text-left"><input name="birthday" type="date"></td>
					</tr>


					<tr>
						<td></td>
						<td class="text-left"><input type="submit" value="添加">
							<input type="button" value="返回"
							onclick="llocation.href='${ctx}/user';"></td>
					</tr>
				</table>

			</form>
		</div>

	</div>
</body>
</html>