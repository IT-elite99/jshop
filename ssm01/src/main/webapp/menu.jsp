<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>OA系统</title>
<%
	String ctx = request.getServletContext().getContextPath();
	application.setAttribute("ctx", ctx);
%>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- basic styles -->

<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets/css/font-awesome.min.css" />

<!-- ace styles -->

<link rel="stylesheet" href="${ctx}/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace-skins.min.css" />

<script src="${ctx}/assets/js/ace-extra.min.js"></script>
</head>
<body>

	<script type="text/javascript">
		try {
			ace.settings.check('main-container', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="main-container-inner">
		<a class="menu-toggler" id="menu-toggler" href="#"> <span
			class="menu-text"></span>
		</a>

		<div class="sidebar" id="sidebar">
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'fixed')
				} catch (e) {
				}
			</script>

			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="icon-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="icon-pencil"></i>
					</button>

					<button class="btn btn-warning">
						<i class="icon-group"></i>
					</button>

					<button class="btn btn-danger">
						<i class="icon-cogs"></i>
					</button>
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<!-- #sidebar-shortcuts -->
			<ul class="nav nav-list">



				<li class="active open"><a href="#" class="dropdown-toggle">
						<i class="icon-list"></i> <span class="menu-text"> 用户管理 </span> <b
						class="arrow icon-angle-down"></b>
				</a>

					<ul class="submenu">
						<li class="active"><a href="${ctx }/user/list"> <i
								class="icon-double-angle-right"></i> 用户列表
						</a></li>

					</ul></li>


			</ul>
			<!-- /.nav-list -->

		</div>
	</div>

</body>
</html>