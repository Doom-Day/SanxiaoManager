<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<label>用户名</label>
				<input type="text" id="uidsignup" name="uidsignup" value="15206110" pattern="^\d{5}$|^\d{9}$" title="请输入学号或者工号" required="required" readonly="readonly"/>
			</p>
			<p>
				<label>密码</label>
				<input type="password" id="upwdsignup" name="upwdsignup" value="Nchu152061" pattern="^(\w){6,20}$" title="只能输入6-20个字母、数字、下划线" required="required"/>
			</p>
			<p>
				<label>真实姓名</label>
				<input type="text" id="unamesignup" name="unamesignup" value="苏镇宇" required="required"/>
			</p>
			<p class="choose">
				<label>性别</label><br>
				<input id="usex0" type="radio" name="usex" value="0"  />
				<label for="usex0">男</label>
				<input id="usex1" type="radio" name="usex" value="1"  />
				<label for="usex1">女</label>
			</p>
			<p>
				<label>手机号码</label>
				<input type="text" id="utelsignup" name="utelsignup" value="15896679232" pattern="^(1\d{10})$" title="请输入正确的手机号" required="required"/>
			</p>
			<p>
				<label>学院</label>
				<input type="text" id="uacsignup" name="uacsignup" value="软件学院" required="required"/>
			</p>
			<p>
				<label>政治面貌</label>
				<input type="text" id="upssignup" name="upssignup" value="团员" required="required"/>
			</p>
			<p>
				<label>地址</label>
				<input type="text" id="uaddsignup" name="uaddsignup" value="南昌航空大学海院" required="required"/>
			</p>
			<p class="text button">
				<input type="submit" value="修改">
				<input type="button" value="返回">
			</p>
		</form>
	</div>
</body>
</html>