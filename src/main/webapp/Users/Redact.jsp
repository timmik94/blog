<%@ page import="java.util.List" %>
<%@ page import="Hibernateclasses.Record" %>
<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 14.06.2014
  Time: 15:08
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
<form method="post" action="/Users/write">
    <p><input type="text" name="title"/></p>
    <p>
        <textarea name="text" cols="60" rows="10"></textarea>
    </p>
    <button type="submit">add</button>
</form>
<hr/>
<form action="home.jsp" method="get">
    <button>to home page</button>
</form>
</body>
</html>
