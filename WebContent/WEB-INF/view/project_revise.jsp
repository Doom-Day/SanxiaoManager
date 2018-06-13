<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<html>
<head>
	<title>修改项目信息</title>
	<link rel="stylesheet"  type="text/css"  href="resources/css/detail.css"/>
	<link rel="stylesheet" media="screen" href="resources/css/table.css" />
</head>
<body>
	<div id="text">
		<form action="projectRevise" method="post">
			<h1>修改</h1>
			<p>
				<label>项目名称</label>
				<input type="text" id="pnamesignup" name="pnamesignup" value="${project.pname}" required="required"/>
			</p>
			<p>
				<label>指导老师</label>
				<input type="text" id="pteasignup" name="pteasignup" value="${project.ptea}" required="required"/>
			</p>
			<p>
				<label>指导老师电话</label>
				<input type="text" id="pttelsignup" name="pttelsignup" value="${project.pttel}" required="required"/>
			</p>
			<p>
				<label>项目简介</label>
				<p id="pprofilesignup" contenteditable="true">
					${project.pprofile}</p>
			</p>
			<p>
				<label>项目计划</label>
				<p id="pplansignup" contenteditable="true">
					${project.pplan}</p>
			</p>
			<p>
				<label>经费需求</label>
				<input type="text" id="pfeesignup" name="pfeesignup" value="${project.pfee}" pattern="^\d+(\.\d+)?$" title="请输入数字" required="required"/>
			</p>
			<p>
			
				<label>类型</label>
				<select id="ptype" name="ptype">
					<option value="国创项目" <c:if test="${project.ptype=='国创项目'}">selected</c:if> >国创项目</option>
				    <option value="重点项目" <c:if test="${project.ptype=='重点项目'}">selected</c:if> >重点项目</option>
				    <option value="一般项目" <c:if test="${project.ptype=='一般项目'}">selected</c:if> >一般项目</option>
				</select>
			</p>
			<p>
				<label>结题形式</label>
				<select id="pof" name="pof">
					<option value="实物" <c:if test="${project.pof=='实物'}">selected</c:if> >实物</option> 
				    <option value="专利" <c:if test="${project.pof=='专利'}">selected</c:if> >专利</option>
				    <option value="软件" <c:if test="${project.pof=='软件'}">selected</c:if> >软件</option>
				    <option value="调查报告" <c:if test="${project.pof=='调查报告'}">selected</c:if> >调查报告</option> 
				    <option value="论文" <c:if test="${project.pof=='论文'}">selected</c:if> >论文</option> 
				    <option value="文艺影视作品" <c:if test="${project.pof=='文艺影视作品'}">selected</c:if> >文艺影视作品</option> 
				</select>
			</p>
			<p>
				<label>项目成员</label>
				<p>
					<table border="0">
						<thead>
				            <tr>
				            	<th>编号</th>
				            	<th>学号</th>
				                <th>姓名</th>
				                <th>年龄</th>
				                <th>性别</th>
				                <th>政治面貌</th>
				                <th>学院</th>
				           	</tr>
				        </thead>
				        <tbody>
				        	<c:forEach var="i" begin="1" end="5">
				        		<c:choose>
					        		<c:when test="${fn:length(member)}>=i">
							            <tr>
							            	<td><p>${i}</p></td>
							                <td><p id="mid_${i}" contenteditable="true">${member.get(i-1).mid}</p></td>
							                <td><p id="mname_${i}" contenteditable="true">${member.get(i-1).mname}</p></td>  
							                <td><p id="mage_${i}" contenteditable="true">${member.get(i-1).mage}</p></td>
							                <td><p id="msex_${i}" contenteditable="true">${member.get(i-1).msex}</p></td>
							                <td><p id="mps_${i}" contenteditable="true">${member.get(i-1).mps}</p></td>
							                <td><p id="mac_${i}" contenteditable="true">${member.get(i-1).mac}</p></td>
							            </tr>
						           </c:when>
						           <c:otherwise>
					           			<tr>
							            	<td><p>${i}</p></td>
							                <td><p id="mid_${i}" contenteditable="true"></p></td>
							                <td><p id="mname_${i}" contenteditable="true"></p></td>  
							                <td><p id="mage_${i}" contenteditable="true"></p></td>
							                <td><p id="msex_${i}" contenteditable="true"></p></td>
							                <td><p id="mps_${i}" contenteditable="true"></p></td>
							                <td><p id="mac_${i}" contenteditable="true"></p></td>
							            </tr>
						           </c:otherwise>
					           </c:choose>
				        	</c:forEach>
				        </tbody>
        			</table>
				</p>
			</p>
			<p class="text button">
				<input type="submit" value="确认修改">
				<input type="button" onclick="javascript:history.back(-1);" value="返回">
			</p>
		</form>
	</div>

</body>
</html>