<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>“三小”项目管理系统</title>
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"  type="text/css"  href="resources/css/login.css"/>
</head>

<body>
	<div id="container">
		<a class="hiddenanchor" id="toregister"></a>  
		<a class="hiddenanchor" id="tologin"></a> 
		<div id="wrapper">  
	        <div id="login" class="animate form"> 
				<form action="log" method="post">
					<h1>登录</h1>
					<p>
						<label for="uid">账号</label>
						<input type="text" id="uid" name="uid" pattern="^\d{5}$|^\d{8}$" title="账号为学号或者工号" required="required"/>
					</p>
					<p>
						<label for="upwd">密码</label>
						<input type="password" id="upwd" name="upwd" required="required" />
					</p>
					<p class="choose">
						<input type="radio" id="uch0" name="uch" value="0" checked />
						<label for="uch0">学生</label>
	            		<input type="radio" id="uch1" name="uch" value="1" />
	            		<label for="uch1">教师</label>
	            	</p>
	            	
	            	<label style="color:red">${message}</label>
					<p class="login button">
						<input type="submit" value="登录" />
					</p>
					<p class="change_link">  
	                    	没有账户?
	                    <a href="#toregister" class="to_register">马上去注册</a>  
	                </p>
				</form>
			</div>
			<div id="register" class="animate form">
				<form action="register" method="post">
					<h1>注册</h1>
					<p>
						<label for="uidsignup">账号</label>
						<input type="text" id="uidsignup" name="uidsignup" pattern="^\d{5}$|^\d{8}$" title="请输入学号或者工号" required="required"/>
					</p>
					<p>
						<label for="upwdsignup">密码</label>
						<input type="password" id="upwdsignup" name="upwdsignup" pattern="^(\w){6,20}$" title="只能输入6-20个字母、数字、下划线" required="required"/>
					</p>
					<p>
						<label for="upwdsignup_confirm">确认密码</label>
						<input type="password" id="upwdsignup_confirm" name="upwdsignup_confirm" required="required"/>
					</p>
					<p>
						<label for="unamesignup">真实姓名</label>
						<input type="text" id="unamesignup" name="unamesignup" required="required"/>
					</p>
					<p class="choose">
						<label for="usexsignup">请选择性别</label>
						<input type="radio" id="usex0" name="usex" value="0" checked>
						<label for="usex0">男</label>
						<input type="radio" id="usex1" name="usex" value="1">
						<label for="usex1">女</label>
					</p>
					<p>
						<label for="utelsignup">手机号码</label>
						<input type="text" id="utelsignup" name="utelsignup" pattern="^(1\d{10})$" title="请输入正确的手机号" required="required"/>
					</p>
					<p>
						<label for="uacsignup">学院</label>
						<input type="text" id="uacsignup" name="uacsignup" required="required"/>
					</p>
					<p>
						<label for="upssignup">政治面貌</label>
						<input type="text" id="upssignup" name="upssignup" required="required"/>
					</p>
					<p>
						<label for="uaddsignup">地址</label>
						<input type="text" id="uaddsignup" name="uaddsignup" required="required"/>
					</p>
					
					<p class="signin button">
						<input type="submit" class="sign_bt" value="注册">
					</p>
					<p class="change_link">
	                    	已经有账户 ?
	                    <a href="#tologin" class="to_register"> 马上去登录 </a>  
	                </p>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="resources/js/login.js"></script>
</body>

</html>