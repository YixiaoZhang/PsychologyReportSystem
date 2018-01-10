<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>查看心理月报表</title>
<meta name="description" content="管理寝室页面">
<meta name="keywords" content="table">
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
	function deleteDormitory() {
		var result = confirm("确定删除该寝室吗？");
		return result;
	}
</script>
<body>
	<!-- content start -->
	<div class="admin-content">
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">心理月报记录表</strong>
				</div>
			</div>

			<hr>
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar"></div>
				</div>
				<form action="QueryReport" method="post">
					<div class="am-u-sm-12 am-u-md-3">
						<div class="am-form-group">
							<select name="method" data-am-selected="{btnSize: 'sm'}">
								<option value="1">按学生学号查询</option>
								<option value="2">按学生姓名查询</option>
								<option value="3">按学生学号查询</option>
							</select>
						</div>
					</div>
					<div class="am-u-sm-12 am-u-md-3">
						<div class="am-input-group am-input-group-sm">
							<input type="text" class="am-form-field" name="input"> <span
								class="am-input-group-btn">
								<button class="am-btn am-btn-default" type="submit">搜索</button>
							</span>
						</div>
					</div>
				</form>
			</div>

			<div class="am-g">
				<div class="am-u-sm-12">
					<table class="am-table am-table-striped am-table-hover table-main">
						<thead>
							<tr>
								<th width="10%">心理月报表</th>
								<th width="10%">学号</th>
								<th width="10%">寝室长学号</th>
								<th>问题一</th>
								<th>问题二</th>
								<th>问题三</th>
								<th>问题四</th>
								<th>问题五</th>
								<th>问题六</th>
								<th>问题七</th>
								<th>问题八</th>
								<th>问题九</th>
								<th width="10%">填写时间</th>
								<!--  <th width="25%">问题二</th>
								<th width="25%">问题三</th>
								<th width="25%">问题四</th>
								<th width="25%">问题五</th>
								<th width="25%">问题六</th>
								<th width="25%">问题七</th>
								<th width="25%">问题八</th>
								<th width="25%">问题九</th>-->
							</tr>
						</thead>
						<tbody>
							<s:iterator value="reportresult" id="report">
								<tr>
									<td><s:property value="#report.reportName" /></td>
									<td><s:property value="#report.studentId" /></td>
									<td><s:property value="#report.fillId" /></td>
									<td><s:property value="#report.answer1" /></td>
									<td><s:property value="#report.answer2" /></td>
									<td><s:property value="#report.answer3" /></td>
									<td><s:property value="#report.answer4" /></td>
									<td><s:property value="#report.answer5" /></td>
									<td><s:property value="#report.answer6" /></td>
									<td><s:property value="#report.answer7" /></td>
									<td><s:property value="#report.answer8" /></td>
									<td><s:property value="#report.answer9" /></td>
									<td><s:property value="#report.time" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>					
					<hr />
					</form>
				</div>

			</div>
		</div>

		<footer class="admin-content-footer">
		<hr>
		<p class="am-padding-left">© JavaEE大型实验</p>
		</footer>

	</div>
	<!-- content end -->




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
