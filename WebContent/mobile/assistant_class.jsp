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
<link rel="stylesheet" href="assets/css/amazeui.min.css"><link rel="stylesheet" href="assets/css/app.css">
</head>
<body>
	<%@ include file="header.jsp"%>

	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
		<h2 class="am-titlebar-title ">本班情况</h2>
	</div>

	<article data-am-widget="paragraph"
		class="am-paragraph am-paragraph-default"
		data-am-paragraph="{ tableScrollable: true, pureview: true }">
	所在班级&nbsp;&nbsp;<span class="am-badge am-badge-primary">${dor0}</span>&nbsp;&nbsp;班<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;本班已完成填写&nbsp;&nbsp;<span class="am-badge am-badge-success">${dor1}</span>&nbsp;&nbsp;份<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;本班当前待填写&nbsp;&nbsp;<span class="am-badge am-badge-warning">${dor2}</span>&nbsp;&nbsp;份<br>

	<br>
	<table
		class="am-table am-table-striped am-table-hover am-table-centered">
		本班同学
		<tr>
			<td>姓名</td>
			<td>学号</td>
			<td>状态</td>
		<tr>
		<s:iterator value="list" id="stu">
		<tr>
			<td><s:property value="#stu.name" /></td>
			<td><s:property value="#stu.id" /><s:property value="#stu.isFill" /></td>
			<td>
			<s:if test="#stu.isFill>0">
			<span class="am-badge am-badge-success" data-am-modal="{target: '#my-alert'}">已填写</span>
			</s:if>
			<s:else>
			<a href="InputRecord?id=<s:property value="#stu.id" />"><span class="am-badge am-badge-warning">待填写</span></a>
			</s:else>
			</td>
		<tr>
		</s:iterator>
	</table>

	</article>

<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">提示</div>
    <div class="am-modal-bd">
      此心理月报已经填写完成！
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn">确定</span>
    </div>
  </div>
</div>


	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
</body>
</html>
