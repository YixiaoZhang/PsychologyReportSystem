<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@taglib prefix="s" uri="/struts-tags" %>
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
<br>1
	<article data-am-widget="paragraph"
		class="am-paragraph am-paragraph-default"
		data-am-paragraph="{ tableScrollable: true, pureview: true }">
	<div data-am-widget="slider" class="am-slider am-slider-a5" data-am-slider='{&quot;directionNav&quot;:false}' >
  <ul class="am-slides">
      <li>
        	<img src="img/index.jpg">
         
      </li>
      <li>
        	<img src="img/index2.jpg">
         
      </li>
  </ul>
</div>
	<br>你好，${session.studentName}！<br>欢迎使用心理月报系统！
	
</article>

<s:if test="#dor0!='100'">
	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
		<h2 class="am-titlebar-title ">寝室长工作</h2>
	</div>
	<article data-am-widget="paragraph"
		class="am-paragraph am-paragraph-default"
		data-am-paragraph="{ tableScrollable: true, pureview: true }">
	当前正在收集&nbsp;&nbsp;<span class="am-badge am-badge-primary">${dor0}</span>&nbsp;&nbsp;<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;您已完成&nbsp;&nbsp;<span class="am-badge am-badge-success">${dor1}</span>&nbsp;&nbsp;份<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;当前待填写&nbsp;&nbsp;<span class="am-badge am-badge-warning">${dor2}</span>&nbsp;&nbsp;份<br>
	<a href="ReportIndex"><button type="button" class="am-btn am-btn-primary am-fr">现在填写</button></a>
</article>
</s:if>

<s:if test="#class0!='100'">
<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
		<h2 class="am-titlebar-title ">心理委员</h2>
	</div>
	<article data-am-widget="paragraph"
		class="am-paragraph am-paragraph-default"
		data-am-paragraph="{ tableScrollable: true, pureview: true }">
	所在班级&nbsp;&nbsp;<span class="am-badge am-badge-primary">${class0}</span>&nbsp;&nbsp;<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;本班已完成填写&nbsp;&nbsp;<span class="am-badge am-badge-success">${class1}</span>&nbsp;&nbsp;份<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;本班当前待填写&nbsp;&nbsp;<span class="am-badge am-badge-warning">${class2}</span>&nbsp;&nbsp;份<br>
	<button type="button" class="am-btn am-btn-primary am-fr">查看详情</button>
</article>
</s:if>


	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
</body>
</html>
