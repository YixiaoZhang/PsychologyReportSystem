<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>新增心理月报表</title>
<meta name="description" content="新增页面">
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
<body>
<div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">新增心理月报表</strong></div>
      </div>

      <hr/>
  <div class="am-u-sm-12 am-u-md-8">
          <form class="am-form am-form-horizontal" action="AddReport" method="post">
            <div class="am-form-group">
              <label for="name" class="am-u-sm-3 am-form-label">心理月报表</label>
              <div class="am-u-sm-9">
                <input type="text" id="name" name="name" placeholder="如：2015级11月心理月报表">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-intro" class="am-u-sm-3 am-form-label">简介 描述</label>
              <div class="am-u-sm-9">
                <textarea class="" rows="5" id="user-intro" placeholder="输入心理月报表描述"></textarea>
              </div>
            </div>
            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <button type="submit" class="am-btn am-btn-primary">添加</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
    
					<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

					<!--[if (gte IE 9)|!(IE)]><!-->
					<script src="../assets/js/jquery.min.js"></script>
					<!--<![endif]-->
					<script src="../assets/js/amazeui.min.js"></script>
					<script src="../assets/js/app.js"></script></body>
</html>