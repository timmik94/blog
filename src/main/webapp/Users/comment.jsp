<%@ page import="Hibernateclasses.Record" %>
<%@ page import="java.util.List" %>
<%@ page import="Hibernateclasses.Comment" %>
<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 14.06.2014
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Record record= (Record) session.getAttribute("record");
    %>
<h1><%=record.getTitle()%></h1>
<div>
    <%=record.getText()%>
</div>

<hr/>
<%
    List<Comment> comments= (List<Comment>) session.getAttribute("comment");
    if(comments!=null){
        for (int i=0;i<comments.size();i++){
            Comment comment=comments.get(i);
            %>

     <p><%=comment.toString()%></p>
    <hr/>
<%

        }
    }
%>

<form action="/Users/comment" method="post">
    <input type="hidden" value="<%=record.getId()%>" name="id">

    <textarea name="text" cols="60" rows="2"></textarea>
    <button type="submit">comment</button>
</form>
<form action="home.jsp" method="get">
    <button>to home page</button>
</form>
</body>
</html>
