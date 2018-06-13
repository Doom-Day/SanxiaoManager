<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	    	<a class="logout_a" href="<c:url value="/" />">注销</a>
	    </div>
	    <t><a href="<c:url value="/information" />">${user.name}</a> 同学，你好！</t>
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
				<c:choose>
					<c:when test="${empty projectList}">
						<tr>
			            	<td colspan="6">没有记录</td>
			            </tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="result" items="${projectList}">
				            <tr>
				                <td>${result.id}</td>
				                <td>${result.name}</td>  
				                <td>${user.name}</td>
				                <td>${result.tea}</td>
				                <td>
				                	<c:choose>
				                		<c:when test="${result.state=='0'}">
				                			未审核
				                		</c:when>
				                		<c:when test="${result.state=='1'}">
				                			进行中
				                		</c:when>
										<c:when test="${result.state=='2'}">
				                			已结题
				                		</c:when>
				                		<c:otherwise>
				                			状态异常
				                		</c:otherwise>
				                	</c:choose>
				                </td>
				                <td><a href="<c:url value="/project_detail?pid=${result.id}" />">详情</a></td>
				            </tr>
						</c:forEach>
					</c:otherwise>
	            </c:choose>
	        </tbody>
	    </table>
	    <div id="addbutton">
			<p class="add button">
				<input type="button" onclick='location.href=("project_add.jsp")' value="申请三小项目">
			</p>
		</div>
	</article>
</body>
</html>