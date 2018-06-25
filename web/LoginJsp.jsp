<%-- 
    Document   : LoginJsp
    Created on : Jun 11, 2018, 8:29:23 PM
    Author     : dilin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <center>
        <!--../src/java/edu/ijse/absd/onlnecmpshp/controller/LoginController-->
        <h1>Login to Continue</h1>
        <form action="LoginController">
            <h3>Username</h3>
            <input type="text" name="username"><br/>
            <h3>Password</h3>
            <input type="password" name="password"><br/><br/>
            <button type="submit">Log in</button>

        </form>
        <!--${pageContext.request.contextPath}-->
    </center>
    <br/>
    <br/>
    <br/>
    <br/>
    <%@include file="footer.jsp" %>
</body>
</html>
