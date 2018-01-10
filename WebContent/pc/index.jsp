<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js fixed-layout">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>心理月报管理系统</title>
<meta name="description" content="主界面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="../assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../assets/css/admin.css">
</head>
<script type="text/javascript">
	function changeFrameHeight() {		
		document.getElementById("iframepage").height = $(window).height()
				- $('header').height()-10;
	}
</script>
<body>
	<header class="am-topbar am-topbar-inverse admin-header">
	<div class="am-topbar-brand">
		<strong>心理月报系统</strong>
	</div>

	<button
		class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
		data-am-collapse="{target: '#topbar-collapse'}">
		<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
	</button>

	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

		<ul
			class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
			<li class="am-dropdown" data-am-dropdown><a
				class="am-dropdown-toggle" data-am-dropdown-toggle
				href="javascript:;"> <span class="am-icon-users"></span>${session.instructorName} <span
					class="am-icon-caret-down"></span>
			</a>
				<ul class="am-dropdown-content">
					<li><a href="login.jsp"><span class="am-icon-power-off"></span> 退出</a></li>
				</ul></li>
			<li class="am-hide-sm-only"><a href="javascript:;"
				id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span
					class="admin-fullText">开启全屏</span></a></li>
		</ul>
	</div>
	</header>

	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
			<div class="am-offcanvas-bar admin-offcanvas-bar">
				<ul class="am-list admin-sidebar-list">
					<li><a href="welcome.jsp" target="iframe_a"><span class="am-icon-home"></span>
							首页</a></li>
					<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav'}"><span
							class="am-icon-university"></span> 管理年级 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub am-in"
							id="collapse-nav">
							<li><a href="ShowAllClasses" class="am-cf" target="iframe_a"><span
									class="am-icon-building"></span> 管理班级<span
									class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
							<li><a href="ShowAllDormitory" target="iframe_a"><span
									class="am-icon-building-o"></span> 管理寝室</a></li>
							<li><a href="ShowAllStudent?page=1" target="iframe_a"><span
									class="am-icon-users"></span> 管理学生<span
									class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>						
						</ul></li>
						
							<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav1'}"><span
							class="am-icon-table"></span>心理月报表 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub am-in"
							id="collapse-nav1">
							<li><a href="ShowAllReport" class="am-cf" target="iframe_a"><span
									class="am-icon-building"></span> 查看心理月报表<span
									class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
							<li><a href="insertReport.jsp" target="iframe_a"><span
									class="am-icon-building-o"></span> 新增心理月报表</a></li>					
						</ul></li>					
				</ul>

				<div class="am-panel am-panel-default admin-sidebar-panel">
					<div class="am-panel-bd">
						<p>
							<span class="am-icon-bookmark"></span> 公告
						</p>
						<p>Javaee大型实验---心理月报管理系统</p>
					</div>
				</div>

				<div class="am-panel am-panel-default admin-sidebar-panel">
					<div class="am-panel-bd">
						<p>
							<span class="am-icon-tag"></span> 
						</p>
						<p>欢迎来到心理月报管理系统!</p>
					</div>
				</div>
			</div>
		</div>
		<!-- sidebar end -->

		<!-- content start  -->
		<div class="admin-content">
			<div class="admin-content-body">
				<iframe onload="changeFrameHeight();" src="welcome.jsp"
					name="iframe_a" scrolling="no" id="iframepage" frameborder="0"
					style="padding: 0px; width: 100%;"></iframe>
			</div>

		</div>

		<!-- content end -->

	</div>


	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="../assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script src="../assets/js/amazeui.min.js"></script>
	<script src="../assets/js/app.js"></script>


</body>
</html>