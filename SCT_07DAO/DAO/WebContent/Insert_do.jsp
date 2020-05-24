<%@page import="com.org.student.factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加操作</title>
</head>
<body>
	<jsp:useBean id="student" scope = "page" class="com.org.student.vo.Student"></jsp:useBean>
	<jsp:setProperty property="*" name="student"/>
	<%if(DAOFactory.getStudentDAOImplInstanse().addMessage(student)){
	%>
		<h2>注册成功！</h2><br>
	<%}else{%>
		<h2>注册失败！</h2><br>
		<%} %>
	<h3>返回请点<a href="showMessage.jsp">这里</a></h3>
</body>
</html>