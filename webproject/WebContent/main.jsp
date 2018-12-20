<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>丑牛小店</title>

<c:set value="${pageContext.request.contextPath }" var="ctx"
	scope="application"></c:set>
<link rel="stylesheet" href="${ctx}/css/layui.css" media="all">
<link rel="stylesheet" href="${ctx}/css/common.css">
<script src="${ctx}/layui/layui.js"></script>

</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">丑牛小店</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">首页</a></li>
				<li class="layui-nav-item"><a href="">我的订单</a></li>
				<li class="layui-nav-item"><a href="">个人信息</a></li>
				<li class="layui-nav-item"><a href="">充值</a></li>
				<li class="layui-nav-item"><a href="javascript:;">注册会员</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件注册</a>
						</dd>
						<dd>
							<a href="">第三方注册</a>
						</dd>
						<dd>
							<a href="">会员特权</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="${ctx }/login.jsp">${loginUser.real_name}
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退出</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">潮流趋势</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">原创个性</a>
							</dd>
							<dd>
								<a href="javascript:;">热门清单</a>
							</dd>
							<dd>
								<a href="javascript:;">美妆种草合集</a>
							</dd>
							<dd>
								<a href="javascript:;">热销服饰</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">精美小物件</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">百搭装饰</a>
							</dd>
							<dd>
								<a href="javascript:;">时尚先驱</a>
							</dd>
							<dd>
								<a href="">奇淫巧技</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="${ctx }/WEB-INF/view/add-order.jsp">购物车</a></li>
					<li class="layui-nav-item"><a href="">关于我们</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">
				<form action="" method="post">
					搜索:<input type="text" name="搜索" value="">
				</form>

			</div>
			<div class="layui-carousel" id="test1">
				<!--这里是内容区，轮播效果显示  -->
				<div class="layui-carousel" id="test1">
					<div carousel-item>
						<div>
							<img alt="" src="${ctx }/images/u.jpg">
						</div>
						<div>
							<img alt="" src="${ctx }/images/u1.jpg">
						</div>
						<div>
							<img alt="" src="${ctx }/images/u2.jpg">
						</div>
						<div>
							<img alt="" src="${ctx }/images/u3.jpg">
						</div>

					</div>
				</div>

			</div>
			<form action="" class="form-goods">
				<ul>
					<li><img alt="" src="${ctx }/images/u.jpg">
						<p class="goods-price">价格：￥</p>
						<p class="go-car">
							<a href="${ctx }/WEB-INF//view/add-order.jsp">加入购物车</a>
						</p></li>
					<li><img alt="" src="${ctx }/images/u1.jpg">
						<p class="goods-price">价格：￥</p>
						<p class="go-car">
							<a href="/WEB-INF/add-order.jsp">加入购物车</a>
						</p></li>
					<li><img alt="" src="${ctx }/images/u2.jpg">
						<p class="goods-price">价格：￥</p>
						<p class="go-car">
							<a href="${ctx }/WEB-INF/view/add-order.jsp">加入购物车</a>
						</p></li>
				</ul>

			</form>

			<div class="layui-footer">
				<!-- 底部固定区域 -->
				<marquee direction="left" behavior="scroll" width="925" height="45"
					loop="-1" style="color: red;">
					亲，欢迎光临丑牛小店，愿您购物愉快，我的百倍用心，愿您十分满意!!! 记得关注我们哟，么么哒 </marquee>

			</div>
		</div>
	</div>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
	<script>
		layui.use('carousel', function() {
			var carousel = layui.carousel;
			//建造实例
			carousel.render({
				elem : '#test1',
				//设置容器宽度
				width : '100%',
				height : '190px',
				//始终显示箭头
				arrow : 'always'
			//,anim: 'updown' //切换动画方式
			});
		});
	</script>
</body>
</html>