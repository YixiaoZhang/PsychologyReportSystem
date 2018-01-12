<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>管理寝室</title>
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
					<strong class="am-text-primary am-text-lg">寝室</strong>
				</div>
			</div>

			<hr>
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default">
								<span class="am-icon-plus"></span> 新增
							</button>
							<button type="button" class="am-btn am-btn-default">
								<span class="am-icon-file-excel-o"></span> 导入
							</button>
						</div>
					</div>
				</div>
				<form action="QueryDormitory" method="post">
					<div class="am-u-sm-12 am-u-md-3">
						<div class="am-form-group">
							<select name="method" data-am-selected="{btnSize: 'sm'}">
								<option value="1">按寝室号查询</option>
								<option value="2">按寝室长姓名查询</option>
								<option value="3">按寝室长学号查询</option>
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
								<th width="25%">寝室</th>
								<th width="25%">寝室长</th>
								<th width="25%">寝室长学号</th>
								<th width="25%">操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="list" id="dormitory">
								<tr>
									<td><s:property value="#dormitory.name" /></td>
									<td><s:property value="#dormitory.leaderName" /></td>
									<td><s:property value="#dormitory.leaderId" /></td>
									<td>
										<form class="am-form" onsubmit="return deleteDormitory();"
											action="DeleteDormitory?id=<s:property value="#dormitory.id" />"
											method="post">
											<div class="am-btn-toolbar">
												<div class="am-btn-group am-btn-group-xs">
													<a
														class="am-btn am-btn-default am-btn-xs am-text-secondary"
														href="ShowUpdateDormitory?id=<s:property value="#dormitory.id" />"><span
														class="am-icon-pencil-square-o"></span>编辑</a>
													<button type="submit"
														class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
														<span class="am-icon-trash-o"></span> 删除
													</button>
													<a class="am-btn am-btn-default am-btn-xs am-text-warning"
														href="ShowSingleDormitory?id=<s:property value="#dormitory.id" />&name=<s:property value="#dormitory.name2" />">
														<span class="am-icon-tripadvisor"></span>查看详情
													</a>
												</div>
											</div>
										</form>
									</td>
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
