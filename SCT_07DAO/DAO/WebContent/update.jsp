<%@page import="com.org.student.factory.DAOFactory"%>
<%@page import="com.org.student.vo.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%!
	String sid,sname,sbirthday;
	int ssex = 3;
%>
<jsp:useBean id="student" scope="page" class="com.org.student.vo.Student" ></jsp:useBean>
<jsp:setProperty property="sid" name="student"/>
<%
	   ArrayList<Student> list = DAOFactory.getStudentDAOImplInstanse().termFind(student.getSid());
		for(Student stu : list){
			sid = stu.getSid();
			sname = stu.getSname();
			sbirthday = stu.getSbirthday();
			ssex = stu.getSsex();
		}
%>
<title><%=sname %>的修改页面</title>
</head>
<body>
	<h1><p><%=sname %>学生的信息修改</p></h1>
	<form action="update_do.jsp" method="post">
			<input type="hidden" name="sid" value = <%=sid %>>
		ID：<input type="text" name="sid" value = <%=sid %> disabled="disabled"><br>
		姓名：<input type="text" name="sname" value = <%=sname %>><br>
		出生日期：<input type="date" name="sbirthday"  id = 'date' placeholder="yyyy-mm-dd" value = <%=sbirthday %>><br>
		性别：<input type="radio" name="ssex" value="1" <% if(ssex == 1){%>checked="checked"<%} %>>男
			  <input type="radio" name="ssex" value="0" <% if(ssex == 0){%>checked="checked"<%} %>>女<br>
		<input type="submit" value = "提交" ><input type="reset" value = "重置">
	</form>
</body>
</html>