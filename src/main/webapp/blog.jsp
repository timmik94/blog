<%@ page import="Hibernateclasses.Record" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 14.06.2014
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%

    List<Record>records= (List<Record>) session.getAttribute("records");
    if(records!=null){
        for (int i=0;i<records.size();i++){
            Record record=records.get(i);
%>
<h3><%=record.getTitle()%></h3>
<p><%=record.getText()%></p>

<%

        }}
%>
<form action="login.jsp" method="get">
    <button type="submit">sign in</button>
</form>
</body>
</html>
