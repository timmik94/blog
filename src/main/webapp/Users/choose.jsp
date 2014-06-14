<%@ page import="java.util.List" %>
<%@ page import="Hibernateclasses.User" %>
<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 14.06.2014
  Time: 16:24
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
<form action="/Users/read">
    <input type="hidden" value="<%=users.get(i).getLogin()%>" name="login"/>
    <button type="submit">read Blog</button>
</form>

<%

        }
    }
%>
<hr/>
<form action="home.jsp" method="get">
    <button>to home page</button>
</form>
</body>
</html>
