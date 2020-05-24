<%@page import="com.org.student.factory.DAOFactory"%>
<%@page import="java.util.ArrayList,com.org.student.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询界面</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<%!String info = null; %>
	<%String info = request.getParameter("info"); %>
	<a href="showMessage.jsp"><button>返回</button></a>
	<form action="select.jsp" method = "post" >
		<input type = "text" name = "info" value = "<%if(info != null){%><%=info %><%} %>"  placeholder = "学号/姓名/出生日期">&nbsp;&nbsp;&nbsp;
		<input type="submit" value = "查询">
		<table>
	<tr class="tr">
		<th>学号</th>
		<th>姓名</th>
		<th>出生日期</th>
	</tr>
	<%
	if(info != null){
		if(info.equals("男")){
			info = "1";
		}
		if(info.equals("女")){
			info = "0";
		}
		ArrayList<Student> list = DAOFactory.getStudentDAOImplInstanse().termFind(info);
 		for (Student stu1 : list) {
 %>
 	<tr class="tr">
 		<td><%=stu1.getSid() %></td>
 		<td><%=stu1.getSname() %></td>
 		<td><%=stu1.getSbirthday() %></td>
 	</tr>
 <%} 
	}
 %>
</table>
</form>
	
</body>
</html>