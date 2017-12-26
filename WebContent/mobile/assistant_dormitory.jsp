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
	<%@ include file="header.jsp"%>

	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
		<h2 class="am-titlebar-title ">心理月报(寝室长)</h2>
	</div>

	<article data-am-widget="paragraph"
		class="am-paragraph am-paragraph-default"
		data-am-paragraph="{ tableScrollable: true, pureview: true }">
	当前正在收集&nbsp;&nbsp;<span class="am-badge am-badge-primary">3</span>&nbsp;&nbsp;月心理月报<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;您已完成&nbsp;&nbsp;<span
		class="am-badge am-badge-success">2</span>&nbsp;&nbsp;份<br>
	&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;当前待填写&nbsp;&nbsp;<span
		class="am-badge am-badge-warning">2</span>&nbsp;&nbsp;份<br>
	<br>
	<table
		class="am-table am-table-striped am-table-hover am-table-centered">
		我负责的寝室长
		<tr>
			<td>姓名</td>
			<td>学号</td>
			<td>状态</td>
		<tr>
		<tr>
			<td>陈峥</td>
			<td>201526810403</td>
			<td><span class="am-badge am-badge-success" data-am-modal="{target: '#my-alert'}">已填写</span></td>
		<tr>
		<tr>
			<td>张忆霄</td>
			<td>201526810427</td>
			<td><span class="am-badge am-badge-success" data-am-modal="{target: '#my-alert'}">已填写</span></td>
		<tr>
		<tr>
			<td>张哲铖</td>
			<td>201526810428</td>
			<td><a href="report_write.jsp"><span class="am-badge am-badge-warning">待填写</span></a></td>
		<tr>
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
