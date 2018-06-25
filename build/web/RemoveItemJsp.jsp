<%-- 
    Document   : RemoveItemJsp
    Created on : Jun 11, 2018, 9:07:11 PM
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
        <h1>Remove Item from Inventory</h1>
        <form method="POST" action="ItemController">
            Item Code : <input type="text" name="code"/><br/>
            <input type="submit" value="Remove" name="action"/>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
