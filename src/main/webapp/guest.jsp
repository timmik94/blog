<%@ page import="Hibernateclasses.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 14.06.2014
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    List<User>users= (List<User>) session.getAttribute("users");
    if(users!=null){
        for (int i=0;i<users.size();i++){
%>
<h2><%=users.get(i).getLogin()%></h2>
<form action="/see" method="get">
    <input type="hidden" value="<%=users.get(i).getLogin()%>" name="login"/>
    <button type="submit">read Blog</button>
</form>

<%

        }
    }
%>
<form action="login.jsp" method="get">
    <button type="submit">sign in</button>
</form>
</body>
</html>
