<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>个人信息设置</title>
	<link rel="stylesheet"  type="text/css"  href="resources/css/information.css"/>
</head>
<body>
	<div id="text">
		<form action="modify" method="post">
			<h1>个人信息</h1>
			<p>
				<label>账号</label>
				<input type="text" id="uidsignup" name="uidsignup" value="${user.uid}" pattern="^\d{5}$|^\d{9}$" title="请输入学号或者工号" required="required" readonly="readonly"/>
			</p>
			<p>
				<label>密码</label>
				<input type="password" id="upwdsignup" name="upwdsignup" value="${user.upwd}" pattern="^(\w){6,20}$" title="只能输入6-20个字母、数字、下划线" required="required"/>
			</p>
			<p>
				<label>真实姓名</label>
				<input type="text" id="unamesignup" name="unamesignup" value="${user.uname}" required="required"/>
			</p>
			<p>
				<label>年龄</label>
				<input type="text" id="uagesignup" name="uagesignup" value="${user.uage}" pattern="^\d{1}$|^\d{2}$" title="请输入正确的年龄" required="required"/>
			</p>
			<p class="choose">
				<label>性别</label><br>
				<input id="usex0" type="radio" name="usex" value="男" <c:if test="${user.usex=='男'}">checked</c:if> />
				<label for="usex0">男</label>
				<input id="usex1" type="radio" name="usex" value="女" <c:if test="${user.usex=='女'}">checked</c:if> />
				<label for="usex1">女</label>
			</p>
			<p>
				<label>手机号码</label>
				<input type="text" id="utelsignup" name="utelsignup" value="${user.utel}" pattern="^(1\d{10})$" title="请输入正确的手机号" required="required"/>
			</p>
			<p>
				<label>学院</label>
				<input type="text" id="uacsignup" name="uacsignup" value="${user.uac}" required="required"/>
			</p>
			<p>
				<label>政治面貌</label>
				<input type="text" id="upssignup" name="upssignup" value="${user.ups}" required="required"/>
			</p>
			<p>
				<label>地址</label>
				<input type="text" id="uaddsignup" name="uaddsignup" value="${user.uadd}" required="required"/>
			</p>
			<p class="text button">
				<input type="submit" value="修改">
				<input type="button" onclick="javascript:history.back(-1);" value="返回">
			</p>
		</form>
	</div>
</body>
</html>