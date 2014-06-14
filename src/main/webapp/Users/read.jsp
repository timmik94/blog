<%@ page import="Hibernateclasses.Record" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 14.06.2014
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%

    List<Record> records= (List<Record>) session.getAttribute("records");
    if(records!=null){
        for (int i=0;i<records.size();i++){
            Record record=records.get(i);
%>
<h3><%=record.getTitle()%></h3>
<form action="/Users/comment" method="get">
    <input type="hidden" value="<%=record.getId()%>" name="id"/>
    <button type="submit">read</button>
</form>

<%

        }}
%>
<form action="home.jsp" method="get">
    <button>to home page</button>
</form>
</body>
</html>
