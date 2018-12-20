
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查询页面</title>
</head>

<body>

	<div class="container">
		<div class="title">用户查询</div>
		<div class="content">
			<div class="search">
				<!--  查询条件回显 -->
				<form action="${ctx }/user" method="post">
					姓名:<input name="name" value="${param.name}"> 密码:<input
						name="password" value="${param.password }"> 
					<input type="submit" value="查询"> <input type="button"
						value="清空" id="clear">

				</form>

			</div>
			<div class=oper-area>
				<button type="button" id="batchDelBtn">批量删除</button>
				<button type="button" id="addUserBtn">+新增</button>
				<button type="button" class="layui-btn layui-btn-xs" id="batchupload">
					<i class="layui-icon">&#xe67c;</i>批量导入
				</button>
			</div>
			<form id="delForm" action="${ctx }/user">
				<input name="oper" type="hidden" value="batchDel">

				<table>
					<tr>
						<th><input type="checkbox" id="checkAll"></th>
						<th>ID</th>
						<th>账号</th>
						<th>姓名</th>
						<th>密码</th>
						<th>性别</th>
						<th>出生日期</th>
						<th>地址</th>
						<th>角色</th>
						<th>邮箱地址</th>
						<th>注册时间</th>
						<th>操作</th>
					</tr>

					<c:if test="${empty page.list }">
						<tr>
							<td colspan="4">没有查询到数据...</td>
						</tr>
					</c:if>



					<c:forEach items="${page.list}" var="user" varStatus="stat">

						<tr>
							<td><input name="id" type="checkbox" value="${user.id}"></td>
							<td>${user.id }</td>
							<td>${user.account }</td>
							<td>${user.real_name }</td>
							<td>${user.password }</td>
							<td>${user.sex==1?"男":(user.sex==0?"女":"保密") }</td>
							<td><fmt:formatDate value="${user.birthday }"
									pattern="yyyy-MM-dd" /></td>
							<td>${user.address}</td>
							<td>${user.role==1?"普通用户":"管理员" }</td>
							<td>${user.email }</td>
							<td><fmt:formatDate value="${user.register_time }"
									pattern="yyyy-MM-dd" /></td>
							<td><a href="${ctx }/user?oper=toUpdate&id=${user.id}">修改
							</a> | <a href="javascript:void(0);" class="delUser"
								userId="${user.id }">删除 </a></td>
						</tr>

					</c:forEach>


				</table>
			</form>
			<w:pager pageSize="${page.pageSize }" pageNo="${page.pageNo }"
				url="${ctx }/user" recordCount="${page.count }" />
		</div>

	</div>
</body>

<script type="text/javascript">
	$(function() {

		$(".delUser").click(function() {

			//弹出一个确认框

			if (confirm("确定要删除吗?删除后不能恢复...")) {
				//真正的去删除
				var userId = $(this).attr("userId");
				//发送一个删除请求 
				//bom dom

				location.href = ctx + '/user?oper=del&id=' + userId;

			}

		})

		//全选事件
		$("#checkAll").click(function() {

			var checked = this.checked;

			if (checked == true) {
				checked = "checked";
			}

			$("input[name=id]").each(function() {

				this.checked = checked;

			});
		})

		//监听批量删除按钮
		$("#batchDelBtn").click(function() {
			//1.判断是否选择了数据
			var length = $("input[name=id]:checked").length;

			if (length == 0) {
				alert("至少要选择一条数据！");
				return;
			}

			if (confirm("确定要删除" + length + "条数据吗?删除后不能恢复...")) {

				$("#delForm").submit();
			}

		})

		//监听新增按钮事件
		$("#addUserBtn").click(function() {
			location.href = ctx + "/user?oper=toAdd";
		})

		$("#clear").click(function() {
			$("input[name=name]").val("");
			$("input[name=password]").val("");

		})

		//获取操作的结果 
		var result = '${sessionScope.operResult}';

		if (result == 'true') {

			openTip(true, '操作成功...');
		}

		if (result == 'false') {
			openTip(false, '操作失败...');

		}

	})
</script>

<script>
layui.use('upload', function(){
  var upload = layui.upload;
   
  //执行实例
  var uploadInst = upload.render({
    elem: '#batchupload' //绑定元素
    ,url: '${ctx}/uploadUser' //上传接口
    ,exts:'xls'
    ,done: function(res){
    	var data = JSON.parse(res);
        openTip(true,"总共："+data.total+",成功:"+data.success);
        
    }
    ,error: function(){
      //请求异常回调
    }
  });
});
</script>

<!-- 操作操作结果 -->
<c:remove var="operResult" scope="session" />
</html>