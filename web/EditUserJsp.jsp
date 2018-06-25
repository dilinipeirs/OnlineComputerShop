<%-- 
    Document   : EditUserJsp
    Created on : Jun 12, 2018, 6:46:09 PM
    Author     : dilin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User Details</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>Edit User Details</h1>
        <form method="POST" action="UserController">
            Username : <input type="text" name="username"/><br/>
            Password : <input type="password" name="pass"/><br/>
            Confirm Password : <input type="password" name="passCon"/><br/>
            Mobile : <input type="text" name="mobile"/><br/>
            <input type="submit" name="action" value="Edit"/>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
