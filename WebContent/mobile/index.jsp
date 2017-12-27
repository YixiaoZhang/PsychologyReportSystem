<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>心理月报系统</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
</head>
<body>
<%@ include file="header.jsp" %>

	<article data-am-widget="paragraph"
		class="am-paragraph am-paragraph-default"
		data-am-paragraph="{ tableScrollable: true, pureview: true }">
	<br>你好，${session.studentName}！<br>欢迎使用心理月报系统！
</article>


	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
		<h2 class="am-titlebar-title ">心理月报</h2>
	</div>

	<article data-am-widget="paragraph"
		class="am-paragraph am-paragraph-default"
		data-am-paragraph="{ tableScrollable: true, pureview: true }">
	当前正在收集&nbsp;&nbsp;<span class="am-badge am-badge-primary">3</span>&nbsp;&nbsp;月心理月报<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;您已完成&nbsp;&nbsp;<span class="am-badge am-badge-success">2</span>&nbsp;&nbsp;份<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;当前待填写&nbsp;&nbsp;<span class="am-badge am-badge-warning">2</span>&nbsp;&nbsp;份<br>
	<button type="button" class="am-btn am-btn-primary am-fr">现在填写</button>
</article>
<br>
<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
		<h2 class="am-titlebar-title ">心理委员</h2>
	</div>

	<article data-am-widget="paragraph"
		class="am-paragraph am-paragraph-default"
		data-am-paragraph="{ tableScrollable: true, pureview: true }">
	所在班级&nbsp;&nbsp;<span class="am-badge am-badge-primary">软工1501</span>&nbsp;&nbsp;班<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;本班已完成填写&nbsp;&nbsp;<span class="am-badge am-badge-success">2</span>&nbsp;&nbsp;份<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;本班当前待填写&nbsp;&nbsp;<span class="am-badge am-badge-warning">2</span>&nbsp;&nbsp;份<br>
	<button type="button" class="am-btn am-btn-primary am-fr">查看详情</button>
</article>


	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
</body>
</html>
