<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>管理心理月报表</title>
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
					<strong class="am-text-primary am-text-lg">心理月报表汇总</strong>
				</div>
			</div>

			<hr>
			<div class="am-g">
				
			</div>

			<div class="am-g">
				<div class="am-u-sm-12">
					<table class="am-table am-table-striped am-table-hover table-main">
						<thead>
							<tr>
								<th width="25%">心理月报表</th>
								<th width="25%">操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="reportresult" id="report">
								<tr>
									<td><s:property value="#report.name" /></td>
									<td>							
											<div class="am-btn-toolbar">
												<div class="am-btn-group am-btn-group-xs">
													<a
														class="am-btn am-btn-default am-btn-xs am-text-secondary"
														href="SetOpen?id=<s:property value="#report.id" />&isOpen=<s:property value="#report.isOpen" />">
														<span class="am-icon-pencil-square-o"></span> 
														<s:if test="#report.isOpen==0">开启</s:if> 
														<s:else>
														关闭
														</s:else> </a> <a
														class="am-btn am-btn-default am-btn-xs am-text-warning"
														href="ShowAllRecord?id=<s:property value="#report.id" />"> <span
														class="am-icon-tripadvisor"></span>查看详情
													</a>
												</div>
											</div>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div class="am-cf">
						<div class="am-fr">
							<ul class="am-pagination">
								<li class="am-disabled"><a href="#">«</a></li>
								<li class="am-active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">»</a></li>
							</ul>
						</div>
					</div>
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
