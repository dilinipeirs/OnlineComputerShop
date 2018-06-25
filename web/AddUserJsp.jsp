<%-- 
    Document   : AddUserJsp
    Created on : Jun 12, 2018, 6:30:18 PM
    Author     : dilin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>Register System User</h1>
        <form method="POST" action="UserController">
            Username : <input type="text" name="username"/><br/>
            Password : <input type="password" name="pass"/><br/>
            Confirm Password : <input type="password" name="passCon"/><br/>
            Mobile : <input type="text" name="mobile"/><br/>
            <input type="submit" name="action" value="Register"/>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
