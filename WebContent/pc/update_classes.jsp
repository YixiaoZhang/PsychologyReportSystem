<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>编辑班级信息</title>
<meta name="description" content="这是一个修改班级信息页面">
<meta name="keywords" content="form">
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
	function updateClasses() {	
		var result = confirm("确定修改班级信息吗？");
		return result;
	}
</script>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<!-- content start -->
	<div class="admin-content">
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">修改班级信息</strong>
				</div>
			</div>

			<hr>
			<form action="UpdateClasses?classesId=${classes.id}" method="post" onsubmit="return updateClasses();">
				<div class="am-tabs am-margin" data-am-tabs>
					<ul class="am-tabs-nav am-nav am-nav-tabs">
						<li class="am-active">班级信息</a></li>
					</ul>
					<div class="am-tabs-bd">
						<div class="am-tab-panel am-fade am-in am-active" id="tab1">					
							<div class="am-g am-margin-top">
								<div class="am-u-sm-4 am-u-md-2 am-text-right">班级名称</div>
								<div class="am-u-sm-8 am-u-md-10">
									<input type="text" id="classesName" name="classesName" value="${classes.name}">
								</div>								
							</div>
							
								<div class="am-g am-margin-top">
								<div class="am-u-sm-4 am-u-md-2 am-text-right">心理委员</div>
								<div class="am-u-sm-8 am-u-md-10">
									<input type="text" id="assistantName" name="assistantName" value="${classes.assistantName}">
								</div>								
							</div>
							
						   	<div class="am-g am-margin-top">
								<div class="am-u-sm-4 am-u-md-2 am-text-right">学号</div>
								<div class="am-u-sm-8 am-u-md-10">
									<input type="text" id="assistantId" name="assistantId" value="${classes.assistantId}">
								</div>								
							</div>
						</div>

						<div class="am-g am-margin-top"></div>
						<div class="am-margin">
							<button type="submit" class="am-btn am-btn-primary am-btn-xs">确认修改</button>
						</div>
					</div>
					</div>
			</form>
			<footer class="admin-content-footer">
			<hr>
			<p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed
				under MIT license.</p>
			</footer>
		</div>
		<!-- content end -->

	</div>

	<a href="#"
		class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<footer>
	<hr>
	<p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under
		MIT license.</p>
	</footer>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>
</body>
</html>