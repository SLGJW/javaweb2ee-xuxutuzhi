<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/11
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>表单</title>
  </head>
  <body>
  <form action="/Demo" method="get">
    用户名: <input type="text" name="username" value=""/><br/>
    密码: <input type="password" name="password" value=""/><br>
    性别: <input type="radio" name="sex" value="女"/>女
    <input type="radio" name="sex" value="男"/>男
    <br>
    爱好:<input type= "checkbox" name = "hobby" value = "Jazz">Jazz
    <input type= "checkbox" name = "hobby" value = "Pop">Pop
    <input type= "checkbox" name = "hobby" value = "Classical">Classical<br>
    日期: <input type="date" name="date"><br>
    <input type="submit" value="提交"/>
  </form>
  </body>
</html>
