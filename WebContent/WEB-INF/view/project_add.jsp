<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>申请项目</title>
	<link rel="stylesheet"  type="text/css"  href="resources/css/detail.css"/>
	<link rel="stylesheet" media="screen" href="resources/css/table.css" />
</head>
<body>
	<div id="text">
		<form action="addroute" onsubmit="" method="post">
			<h1>申请</h1>
			<p>
				<label>项目名称</label>
				<input type="text" id="pnamesignup" name="pnamesignup" required="required"/>
			</p>
			<p>
				<label>指导老师</label>
				<input type="text" id="pteasignup" name="pteasignup" required="required"/>
			</p>
			<p>
				<label>指导老师电话</label>
				<input type="text" id="pttelsignup" name="pttelsignup" required="required"/>
			</p>
			<p>
				<label>项目简介</label>
				<p id="pprofilesignup" contenteditable="true">
					点击此处添加项目简介（300字以内）</p>
			</p>
			<p>
				<label>项目计划</label>
				<p id="pplansignup" contenteditable="true">
					点击此处添加项目计划（500字以内）</p>
			</p>
			<p>
				<label>经费需求</label>
				<input type="text" id="pfeesignup" name="pfeesignup" pattern="^\d+(\.\d+)?$" title="请输入数字" required="required"/>
			</p>
			<p>
				<label>类型</label>
				<select id="ptype" name="ptype">
					<option value="国创项目">国创项目</option> 
				    <option value="重点项目">重点项目</option>
				    <option value="一般项目">一般项目</option> 
				</select>
			</p>
			<p>
				<label>结题形式</label>
				<select id="pof" name="pof">
					<option value="实物">实物</option> 
				    <option value="专利">专利</option>
				    <option value="软件">软件</option>
				    <option value="调查报告">调查报告</option> 
				    <option value="论文">论文</option> 
				    <option value="文艺影视作品">文艺影视作品</option> 
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
				        <%for(int i=1;i<6;i++){%>
				            <tr>
				            	<td><p><%=i%></p></td>
				                <td><p id="mid_<%=i%>" contenteditable="true"></p></td>
				                <td><p id="mname_<%=i%>" contenteditable="true"></p></td>  
				                <td><p id="mage_<%=i%>" contenteditable="true"></p></td>
				                <td><p id="msex_<%=i%>" contenteditable="true"></p></td>
				                <td><p id="mps_<%=i%>" contenteditable="true"></p></td>
				                <td><p id="mac_<%=i%>" contenteditable="true"></p></td>
				            </tr>
				        <%} %>
				        </tbody>
        			</table>
				</p>
			</p>
			<p class="text button">
				<input type="submit" value="确认申请">
				<input type="button" onclick='' value="返回">
			</p>
		</form>
	</div>

</body>
</html>