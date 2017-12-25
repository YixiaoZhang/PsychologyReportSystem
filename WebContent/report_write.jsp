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
		<h2 class="am-titlebar-title ">填写月报</h2>
	</div>

	<article data-am-widget="paragraph"
		class="am-paragraph am-paragraph-default"
		data-am-paragraph="{ tableScrollable: true, pureview: true }">
	当前正在填写&nbsp;&nbsp;<span class="am-badge am-badge-success">张忆霄</span>&nbsp;&nbsp;的&nbsp;&nbsp;<span
		class="am-badge am-badge-success">5</span>&nbsp;&nbsp;月心理月报<br>
	<br>
	<div style="text-align: center;">
		<h2>心理月报表</h2>
	</div>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每一个人都会遇到困惑，如能及时给予支持，Ta将尽早走出困境，而你正在做的恰是予人玫瑰，让我可以走到Ta身边，给予陪伴和帮助。

<br>
<br>&nbsp;&nbsp;<span class="am-badge am-badge-primary am-round">Part1</span>&nbsp;选择题（必填）
	<table class="am-table am-table-striped am-table-hover">
		<tr>
			<td class="am-text-center" width="70%">描述</td>
			<td>是否符合</td>
		</tr>
		<tr>
			<td class="am-text-middle">睡眠不好持续两周以上</td>
			<td>
				<div class="am-radio">
					<label> <input type="radio" name="radio1"
						value="true"> 存在
					</label>
				</div>

				<div class="am-radio">
					<label> <input type="radio" name="radio1"
						value="false"> 不存在
					</label>
				</div>
			</td>
		</tr>
		<tr>
			<td class="am-text-middle">情绪低落持续两周以上，或流露出无望或无助的心情</td>
			<td>
				<div class="am-radio">
					<label> <input type="radio" name="radio2"
						value="true"> 存在
					</label>
				</div>

				<div class="am-radio">
					<label> <input type="radio" name="radio2"
						value="false"> 不存在
					</label>
				</div>
			</td>
		</tr>
		<tr>
			<td class="am-text-middle">人际关系紧张，与老师，与室友常起冲突</td>
			<td>
				<div class="am-radio">
					<label> <input type="radio" name="radio3"
						value="true"> 存在
					</label>
				</div>

				<div class="am-radio">
					<label> <input type="radio" name="radio3"
						value="false"> 不存在
					</label>
				</div>
			</td>
		</tr>
		<tr>
			<td class="am-text-middle">情绪、行为明显异常，与平日表现不同</td>
			<td>
				<div class="am-radio">
					<label> <input type="radio" name="radio4"
						value="true"> 存在
					</label>
				</div>

				<div class="am-radio">
					<label> <input type="radio" name="radio4"
						value="false"> 不存在
					</label>
				</div>
			</td>
		</tr>
		<tr>
			<td class="am-text-middle">自我要求高，追求完美，学习压力很大</td>
			<td>
				<div class="am-radio">
					<label> <input type="radio" name="radio5"
						value="true"> 存在
					</label>
				</div>

				<div class="am-radio">
					<label> <input type="radio" name="radio5"
						value="false"> 不存在
					</label>
				</div>
			</td>
		</tr>
		<tr>
			<td class="am-text-middle">生活中发生重大事件，如家庭变故，自然灾害，感情受挫，频繁出现意外事故，或突发疾病，或长期患病、服药，或疑似卷入网络借贷</td>
			<td>
				<div class="am-radio">
					<label> <input type="radio" name="radio6"
						value="true"> 存在
					</label>
				</div>

				<div class="am-radio">
					<label> <input type="radio" name="radio6"
						value="false"> 不存在
					</label>
				</div>
			</td>
		</tr>
		<tr>
			<td class="am-text-middle">性格孤僻，独来独往，为人或行踪神秘，不知道他的想法，也从不对人诉说</td>
			<td>
				<div class="am-radio">
					<label> <input type="radio" name="radio7"
						value="true"> 存在
					</label>
				</div>

				<div class="am-radio">
					<label> <input type="radio" name="radio7"
						value="false"> 不存在
					</label>
				</div>
			</td>
		</tr>
		<tr>
			<td class="am-text-middle">常夜不归宿，或特别容易被他人忽略</td>
			<td>
				<div class="am-radio">
					<label> <input type="radio" name="radio8"
						value="true"> 存在
					</label>
				</div>

				<div class="am-radio">
					<label> <input type="radio" name="radio8"
						value="false"> 不存在
					</label>
				</div>
			</td>
		</tr>
		<tr>
			<td class="am-text-middle">直接或间接谈论过自杀，或开自杀方面的玩笑，或考虑过自杀方法</td>
			<td>
				<div class="am-radio">
					<label> <input type="radio" name="radio9"
						value="true"> 存在
					</label>
				</div>

				<div class="am-radio">
					<label> <input type="radio" name="radio9"
						value="false"> 不存在
					</label>
				</div>
			</td>
		</tr>
	</table>
	<br>&nbsp;&nbsp;<span class="am-badge am-badge-primary am-round">Part2</span>&nbsp;其他说明（选填）
     <input type="text" class="am-form-field am-round" />
<br><br>

<div class="am-text-center"> 
   <button type="submit" class="am-btn am-btn-default">&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;&nbsp;&nbsp;交&nbsp;&nbsp;&nbsp;&nbsp;</button></div>
<br><br>



	</article>


	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
</body>
</html>
