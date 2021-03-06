<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Header -->
<header data-am-widget="header" class="am-header am-header-default">
	<div class="am-header-left am-header-nav">
		<a href="CenterIndex" class=""> <i
			class="am-header-icon am-icon-home"></i>
		</a>
	</div>

	<h1 class="am-header-title">
		<a href="#title-link" class=""> 心理月报系统 </a>
	</h1>

	<div class="am-header-right am-header-nav">
		<a href="#right-link" class=""> <i
			class="am-header-icon am-icon-bars"></i>
		</a>
	</div>
</header>

<!-- Menu -->
<nav data-am-widget="menu" class="am-menu  am-menu-slide1"
	data-am-menu-collapse>
	<a href="javascript: void(0)" class="am-menu-toggle"> <i
		class="am-menu-toggle-icon am-icon-bars"></i>
	</a>

	<ul class="am-menu-nav am-avg-sm-4 am-collapse">
		<s:if test="#session.isDor">
			<li class=""><a href="ReportIndex" class="">寝室长</a></li>
		</s:if>
		<li class="am-parent"><a href="##" class="">消息中心</a>
			<ul class="am-menu-sub am-collapse  am-avg-sm-3 ">
				<li class=""><a href="##" class="">新建对话</a></li>
				<li class=""><a href="##" class="">我的对话</a></li>
			</ul></li>
		<s:if test="#session.isAss">
			<li class="am-parent"><a href="#c3" class="">心理委员</a>
				<ul class="am-menu-sub am-collapse  am-avg-sm-3 ">
					<li class=""><a href="ShowDormitory" class="">寝室长月报</a></li>
					<li class=""><a href="ClassesIndex" class="">本班情况</a></li>
				</ul></li>
		</s:if>
		<li class="am-parent"><a href="##" class="">个人中心</a>
			<ul class="am-menu-sub am-collapse  am-avg-sm-3 ">
				<li class=""><a href="CenterInfo" class="">我的信息</a></li>
				<li class=""><a href="center_password.jsp" class="">修改密码</a></li>
			</ul></li>


	</ul>
</nav>