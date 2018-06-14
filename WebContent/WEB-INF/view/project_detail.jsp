<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>项目详情</title>
	<link rel="stylesheet"  type="text/css"  href="resources/css/detail.css"/>
	<link rel="stylesheet" media="screen" href="resources/css/table.css" />
</head>
<body>
	<div id="text">
		<form action="changePstate?pid=${project.pid}" method="post">
		<h1>第${project.psession}届三小项目详情</h1>
		<p>
			<label>项目名称</label>
			<t>${project.pname}</t>
		</p>
		<p>
			<label>负责人</label>
			<t>${project.uname}</t>
			<label style="padding-left:300px">政治面貌</label>
			<t>${project.ups}</t>
		</p>
		<p>
			<label>年龄</label>
			<t>${project.uage}</t>
			<label style="padding-left:250px">学院</label>
			<t>${project.uac}</t>
		</p>
		<p>
			<label>通讯地址</label>
			<t>${project.uadd}</t>
			<label style="padding-left:120px">电话</label>
			<t>${project.utel}</t>
		</p>
		<p>
			<label>指导老师</label>
			<t>${project.ptea}</t>
			<label style="padding-left:200px">指导老师电话</label>
			<t>${project.pttel}</t>
		</p>
		<p>
			<label>项目简介</label>
			<p><t>${project.pprofile}</t></p>
		</p>
		<p>
			<label>项目计划</label>
			<p><t>${project.pplan}</t></p>
		</p>
		<p>
			<label>经费</label>
			<t>${project.pfee}</t>
		</p>
		<p>
			<label>类型</label>
			<t>${project.ptype}</t>
			<label style="padding-left:100px">结题形式</label>
			<t>${project.pof}</t>
		</p>
		<p>
			<label>项目成员</label>
			<c:choose>
				<c:when test="${empty member}">
					<t>没有成员</t>
				</c:when>
				<c:otherwise>
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
						        <c:forEach var="result" items="${member}">
						            <tr>
						            	<td>${result.mid}</td>
						                <td>${result.mname}</td>
						                <td>${result.mage}</td>  
						                <td>${result.msex}</td>
						                <td>${result.mps}</td>
						                <td>${result.mac}</td>
						            </tr>
						        </c:forEach>
					        </tbody>
		       			</table>
					</p>
				</c:otherwise>
			</c:choose>
		</p>
		<p class="text button">
		<c:choose>
			<c:when test="${user.ch=='0'}">
				<input type="button" onclick='location.href=("project_revise.jsp")' value="修改">
			</c:when>
			<c:when test="${user.ch=='1'}">
				<c:choose>
					<c:when test="${project.pstate=='0'}">
						<input type="submit" value="同意立项">
					</c:when>
					<c:when test="${project.pstate=='1'}">
						<input type="submit" value="同意结题">
					</c:when>
				</c:choose>
			</c:when>
		</c:choose>
			<input type="button" onclick="javascript:history.back(-1);" value="返回">
		</p>
		</form>
	</div>

</body>
</html>