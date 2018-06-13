<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>教师主页</title>
	<link rel="stylesheet" media="screen" href="resources/css/student.css" />
	<link rel="stylesheet" media="screen" href="resources/css/table.css" />
</head>
<body>
	<top>
		<h2 class="dilate">三小信息管理系统</h2>
	    <div class="logout">
	    	<a class="logout_a" href="<c:url value="/" />">注销</a>
	    </div>
	    <t><a href="<c:url value="/information" />">${user.name}</a> 老师，你好！</t>
	</top>
	<br><br>
	<article>
		<table>
	        <thead>
	            <tr>
	            	<th>项目编号</th>
	                <th>项目名称</th>
	                <th>责任人</th>
	                <th>学号</th>
	                <th>联系电话</th>
	                <th>指导老师</th>
	                <th>结题形式</th>
	                <th>立项金额</th>
	                <th>状态</th>
	                <th>操作</th>
	           	</tr>
	        </thead>  
	        <tbody>
				<c:choose>
					<c:when test="${empty projectList}">
						<tr>
			            	<td colspan="10">无人申报</td>
			            </tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="result" items="${projectList}">
				            <tr>
				                <td>${result.pid}</td>
				                <td>${result.pname}</td>  
				                <td>${result.uname}</td>
				                <td>${result.uid}</td>
				                <td>${result.utel}</td>
				                <td>${result.ptea}</td>
				                <td>${result.pof}</td>
				                <td>${result.pfee}</td>
				                <td>
									<c:choose>
				                		<c:when test="${result.pstate=='0'}">
				                			未审核
				                		</c:when>
				                		<c:when test="${result.pstate=='1'}">
				                			进行中
				                		</c:when>
										<c:when test="${result.pstate=='2'}">
				                			已结题
				                		</c:when>
				                		<c:otherwise>
				                			状态异常
				                		</c:otherwise>
				                	</c:choose>
								</td>
				                <td><a href="<c:url value="/project_detail?pid=${result.pid}" />">详情</a></td>
				            </tr>
				         </c:forEach>
					</c:otherwise>
	            </c:choose>
	        </tbody>
	    </table>
	</article>
</body>
</html>