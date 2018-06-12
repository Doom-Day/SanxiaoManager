<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>项目详情</title>
	<link rel="stylesheet"  type="text/css"  href="resources/css/detail.css"/>
	<link rel="stylesheet" media="screen" href="resources/css/table.css" />
</head>
<body>
	<div id="text">
		<h1>详情</h1>
		<p>
			<label>项目名称</label>
			<t>三小管理系统</t>
		</p>
		<p>
			<label>负责人</label>
			<t>苏镇宇</t>
			<label style="padding-left:300px">政治面貌</label>
			<t>团员</t>
		</p>
		<p>
			<label>出生年月</label>
			<t>1996.3.29</t>
			<label style="padding-left:250px">学院</label>
			<t>软件学院</t>
		</p>
		<p>
			<label>通讯地址</label>
			<t>南昌航空大学海院</t>
			<label style="padding-left:120px">电话</label>
			<t>15797622635</t>
		</p>
		<p>
			<label>指导老师</label>
			<t>蔡柯</t>
			<label style="padding-left:200px">指导老师电话</label>
			<t>13000000000</t>
		</p>
		<p>
			<label>项目简介</label>
			<p><t>项目简介（300字以内）</t></p>
		</p>
		<p>
			<label>项目计划</label>
			<p><t>项目计划（500字以内）</t></p>
		</p>
		<p>
			<label>经费</label>
			<t>1000</t>
		</p>
		<p>
			<label>类型</label>
			<t>一般项目</t>
			<label style="padding-left:100px">结题形式</label>
			<t>软件</t>
		</p>
		<p>
			<label>项目成员</label>
			<p>
				<table border="0">
					<thead>
			            <tr>
			            	<th>学号</th>
			                <th>姓名</th>
			                <th>年龄</th>
			                <th>性别</th>
			                <th>政治面貌</th>
			                <th>学院</th>
			           	</tr>
			        </thead>
			        <tbody>
			            <tr>
			            	<td>15206136</td>
			                <td>邹江瑞</td>
			                <td>20</td>  
			                <td>男</td>
			                <td>党员</td>
			                <td>软件学院</td>
			            </tr>
			        </tbody>
       			</table>
			</p>
		</p>
		<p class="text button">
		<%if(true){//当为学生时%>
			<input type="button" value="修改">
		<%}
		else{
			if(true){%>
				<input type="button" value="同意立项">
			<%}
			else{%>
				<input type="button" value="同意结题">
		<%}} %>
			<input type="button" onclick='' value="返回">
		</p>
	</div>

</body>
</html>