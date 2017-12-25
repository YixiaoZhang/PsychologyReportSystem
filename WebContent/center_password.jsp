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
		<h2 class="am-titlebar-title ">修改密码</h2>
	</div>

	 <article data-am-widget="paragraph"
           class="am-paragraph am-paragraph-default"
           data-am-paragraph="{ tableScrollable: true, pureview: true }"> <br>
	&nbsp;&nbsp;当前用户：&nbsp;<b>张忆霄</b>
	<br><br>
<div class="am-text-center"> 
<table border="0">
  <tr>
    <td width="30%">旧密码</td>
    <td width="10%">&nbsp;&nbsp;</td>
    <td width="60%"><input type="password" name="" id="password" value=""/> </td>
  </tr>
  <tr>
    <td>新密码</td>
    <td>&nbsp;&nbsp;</td>
    <td><input type="password" name="" id="newpassword" value=""/> </td>
  </tr>
  <tr>
    <td>重&nbsp;&nbsp;&nbsp;&nbsp;复</td>
    <td>&nbsp;&nbsp;</td>
    <td><input type="password" name="" id="newpassword2" value=""/> </td>
  </tr>
</table>
<br><br>
   <button type="submit" class="am-btn am-btn-default">&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;&nbsp;&nbsp;交&nbsp;&nbsp;&nbsp;&nbsp;</button></div>
<br><br>

</div>
	

	<br>

	</article>

	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
</body>
</html>
