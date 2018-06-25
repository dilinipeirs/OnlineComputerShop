<%-- 
    Document   : RemoveUserJsp
    Created on : Jun 12, 2018, 6:46:56 PM
    Author     : dilin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>Remove User from System</h1>
        <form method="POST" action="UserController">
            Username : <input type="text" name="username"/><br/>
            <input type="submit" value="Remove" name="action"/>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
