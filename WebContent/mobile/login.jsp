<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>心理月报系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<style>
.header {
	text-align: center;
}

.header h1 {
	font-size: 200%;
	color: #333;
	margin-top: 30px;
}

.header p {
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="header">
		<div class="am-g">
			<h1>心理月报系统</h1>
			<p>
				浙江工业大学<br />计算机科学与技术学院、软件学院
			</p>
		</div>

	</div>
	<div class="am-g">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
			<hr>
			
			<form action="CheckLoginMobile" method="post" class="am-form">
				<label for="email">学号</label> <input type="text" name="id" id="id"
					value=""> <br> <label for="password">密码</label> <input
					type="password" name="password" id="password" value=""> <br>
					<s:if test="#error=='true'"><a class="am-badge am-badge-danger">学号或密码错误！</a><br><br></s:if>
				<div class="am-cf">
					<input type="submit" name="" value="登 录"
						class="am-btn am-btn-primary am-btn-sm am-fl">
				</div>
				
			</form>
			<hr>
			<p>© 2017 JavaEE 大型实验.</p>
		</div>
	</div>
</body>
</html>
