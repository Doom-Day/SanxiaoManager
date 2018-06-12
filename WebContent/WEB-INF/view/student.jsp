<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>学生主页</title>
	<link rel="stylesheet" media="screen" href="resources/css/student.css" />
	<link rel="stylesheet" media="screen" href="resources/css/table.css" />
</head>
<body>
	<top>
		<h2 class="dilate">三小信息管理系统</h2>
	    <div class="logout">
	    	<a class="logout_a" href="login.jsp">注销</a>
	    </div>
	    <t><a href="">苏镇宇</a> 同学，你好！</t>
	</top>
	<br><br>
	<article>
		<table>
	        <thead>
	            <tr>
	            	<th>项目编号</th>
	                <th>项目名称</th>
	                <th>责任人</th>
	                <th>指导老师</th>
	                <th>状态</th>
	                <th>操作</th>
	           	</tr>
	        </thead>  
	        <tbody>  
	            <tr>
	                <td>1</td>
	                <td>三小管理信息系统</td>  
	                <td>苏镇宇</td>
	                <td>蔡柯</td>
	                <td>申请中</td>
	                <td><a href="">详情</a></td>
	            </tr>
	            <tr>
	                <td>2</td>
	                <td>管理信息系统</td>  
	                <td>镇宇</td>
	                <td>蔡柯</td>
	                <td>申请中</td>
	                <td><a href="">详情</a></td>
	            </tr>
	            <tr>
	                <td>3</td>
	                <td>信息系统</td>  
	                <td>苏镇宇</td>
	                <td>蔡柯</td>
	                <td>申请中</td>
	                <td><a href="">详情</a></td>
	            </tr>
	        </tbody>
	    </table>
	    <div id="addbutton">
			<p class="add button">
				<input type="button" onclick='' value="申请三小项目">
			</p>
		</div>
	</article>
</body>
</html>