<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>管理学生</title>
<meta name="description" content="管理学生页面">
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
	function deleteStudent() {
		var result = confirm("确定删除该学生的所有信息吗？");
		return result;
	}
</script>
<body>
	<!-- content start -->
	<div class="admin-content">
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">学生</strong>
				</div>
			</div>

			<hr>
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default">
								<span class="am-icon-plus"></span><a href="insertStudent.jsp">
									新增</a>
							</button>
							<button type="button" class="am-btn am-btn-default">
								<span class="am-icon-file-excel-o"></span> 导入
							</button>
						</div>
					</div>
				</div>
				<form action="QueryStudent" method="post">
					<div class="am-u-sm-12 am-u-md-3">
						<div class="am-form-group">
							<select name="method" data-am-selected="{btnSize: 'sm'}">
								<option value="1">按姓名查询</option>
								<option value="2">按学号查询</option>
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
								<th width="20%">学号</th>
								<th width="20%">姓名</th>
								<th width="20%">性别</th>
								<th width="20%">班级</th>
								<th width="20%">操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="list" id="student">
								<tr>
									<td><s:property value="#student.id" /></td>
										<td><s:property value="#student.name" /></td>
										<td><s:property value="#student.sex" /></td>
										<td><s:property value="#student.classesName" /></td>
									<td>
										<form class="am-form" onsubmit="return deleteStudent();"
											action="DeleteStudent?id=<s:property value="#student.id" />"
											method="post">
											<div class="am-btn-toolbar">
												<div class="am-btn-group am-btn-group-xs">
													<a
														class="am-btn am-btn-default am-btn-xs am-text-secondary"
														href="ShowUpdateStudent?id=<s:property value="#student.id" />"><span
														class="am-icon-pencil-square-o"></span>编辑</a>
													<button type="submit"
														class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
														<span class="am-icon-trash-o"></span> 删除
													</button>
												</div>
											</div>
										</form>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div class="am-cf">
					<hr />
				</div>

			</div>
		</div>

		<footer class="admin-content-footer">
		<hr>
		<p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under
			MIT license.</p>
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
